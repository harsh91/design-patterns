package question2;

// File   : gui-lowlevel/paintpanel/PaintPanel.java
// Purpose: Draws graphics, handles mouse events.
//          Has setters for shape and color.
// Author : Fred Swartz - October 12, 2006 - Placed in public domain.
// Possible enhancements:
//          * Allow dragging shapes up or to left, not just down+right.
//                by using max/min of coordinates.



import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.*;

///////////////////////////////////////////////////////////////////// PaintPanel
class PaintPanel extends JPanel implements MouseListener, MouseMotionListener,command {
    
    //================================================================ constants
    private static final int SIZE = 500;     // Size of paint area.
    private static final Shape INIIIAL_SHAPE = Shape.RECTANGLE;
    private static final Color INITIAL_COLOR = Color.RED;
    private static final Color COLOR_BACKGROUND = Color.WHITE;
    private enum         State { IDLE, DRAGGING }
    
    //=================================================================== fields
    private State _state = State.IDLE;
    private Shape _shape = INIIIAL_SHAPE;
    private Color _color = INITIAL_COLOR;
    
    private Point _start = null; // Where mouse is pressed.
    private Point _end   = null; // Where mouse is dragged to or released.
    
   //    Initialized first time paintComponent is called.
    private  BufferedImage _bufImage = null;
    private  Graphics2D g2 = null;
    
    //============================================================== constructor
    public PaintPanel() {
        setPreferredSize(new Dimension(1000, 1000));
    	setOpaque(true);
        setBackground(Color.WHITE);
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    //================================================================= setShape
    public void setShape(Shape shape) {
        _shape = shape;
    }
    
    //================================================================= setColor
    public void setColor(Color color) {
        _color = color;
    }
    
    
     public Stack<BufferedImage> onStack = new Stack<BufferedImage>();
     public Stack<BufferedImage> offStack = new Stack<BufferedImage>();
     public Map<String, Coloring> mappedColors = new HashMap<String, Coloring>();
    //=========================================================== paintComponent
    @Override public void paint(Graphics g) {
         g2 = (Graphics2D)g;  // Downcast to Graphics2D
        
        //... One time initialization of in-memory, saved image.
        if (_bufImage == null) {
            //... This is the first time, initialize _bufImage
            int w = this.getWidth();
            int h = this.getHeight();
            _bufImage = (BufferedImage)this.createImage(w, h);
            Graphics2D gc = _bufImage.createGraphics();
            gc.setColor(Color.white);
            gc.fillRect(0, 0, w, h); // fill in background
           
        }
        
        //... Display the saved image.
        g2.drawImage(_bufImage, null, 0, 0);
        
        //... Overwrite the screen display with currently dragged image.
        if (_state == State.DRAGGING) {
            //... Write shape that is being dragged over the screen image,
            //    but not into the saved buffered image.  It will be written
            //    on the saved image when the mouse is released.
            drawCurrentShape(g2);
            
        }
    }
    
    @Override
	public void undo() {
		System.out.println("Stack size after undo : "+ onStack.size());
	    	if(onStack.size()>0){
	    		BufferedImage bi = onStack.pop();
	    		try {
					setImage(bi);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		offStack.push(bi);
	    	}else{
	    		JOptionPane.showMessageDialog(null, "No more undo");
	    	}
	}
    
    public void undo_function()throws IOException{
    	if(onStack.size()>0){
    		BufferedImage bi = onStack.pop();
    		setImage(bi);
    		offStack.push(bi);
    	}else{
    		JOptionPane.showMessageDialog(null, "No more undo");
    	}
    }
    
    @Override
	public void redo() {
		System.out.println("Stack size after redo: " + offStack.size());
    	if(offStack.size()>0){
    		BufferedImage bi = offStack.pop();
    		try {
				setImage(bi);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
    		
    	}else{
    		JOptionPane.showMessageDialog(null, "No more redo");
    	}
	}
	
	public void redo_function() throws IOException{
    	System.out.println(offStack.size());
    	if(offStack.size()>0){
    		BufferedImage bi = offStack.pop();
    		setImage(bi);
    	}else{
    		JOptionPane.showMessageDialog(null, "No more redo");
    	}
    }
    
    public  void setImage(BufferedImage img)throws IOException {
    	
    	g2 = (Graphics2D) img.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.black);
        _bufImage = img;
        this.repaint();    
    }
    
    //========================================================= drawCurrentShape
    private void drawCurrentShape(Graphics2D g2) {
        //... Draws current shape on a graphics context, either
        //    on the context passed to paintComponent, or the
        //    context for the BufferedImage.
        
        g2.setColor(_color);    // Set the color.
        switch (_shape) {
            case OVAL:
                g2.fillOval(_start.x, _start.y, _end.x - _start.x, _end.y - _start.y);
                break;
                
            case RECTANGLE:
                g2.fillRect(_start.x, _start.y, _end.x - _start.x, _end.y - _start.y);
                break;
                
            case LINE:
                g2.drawLine(_start.x, _start.y, _end.x  , _end.y);
                break;
                
            default:  // Should never happen!
                g2.drawString("Huh?", 10, 20);
                break;
        }
    }
   
    //============================================================= mousePressed
    public void mousePressed(MouseEvent e) {
    	onStack.push(_bufImage); //pushing the previous buffered image on to the stack
    	System.out.println("Image pushed on to undo stack");
    	//un.push_item(copyImage(_bufImage));
        _state = State.DRAGGING;   // Assume we're starting a drag.
        
        _start = e.getPoint();     // Save start point, and also initially
        _end   = _start;           // as end point, which drag will change.
    }
    
    //============================================================= mouseDragged
    public void mouseDragged(MouseEvent e) {
        _state = State.DRAGGING;   // We're dragging to create a shape.
        
        _end = e.getPoint();       // Set end point of drag.  May change.
        this.repaint();            // After change, show new shape
    }
    
    //============================================================ mouseReleased
    public void mouseReleased(MouseEvent e) {
    	
        //... If released at end of drag, write shape into the BufferedImage,
        //    which saves it in the drawing.
    	
        _end = e.getPoint();      // Set end point of drag.
        if (_state == State.DRAGGING) {
            _state = State.IDLE;
            
            //... Draw current shape in saved buffered image.
            drawCurrentShape(_bufImage.createGraphics());
            this.repaint();
            offStack.push(_bufImage);
            
        }
    }
    
   
    //================================================== ignored mouse listeners
    public void mouseMoved  (MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited (MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}

}