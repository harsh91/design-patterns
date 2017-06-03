package question2;

//File   : gui-lowlevel/paintdemo/PaintDemo.java
//Purpose: A simple painting program.
//       Illustrates use of mouse listeners and BufferedImage.
//       Runs as both applet and main program.
//Author : Fred Swartz 2002, 2006-10-13 - Placed in public domain.
//Possible Enhancements:
//* Clear drawing area
//* Other shapes.
//* An eraser (define new shape, draw on buffered image during drag).

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//////////////////////////////////////////////////////////////////////PaintDemo
public class PaintDemo extends JApplet {
	// ===================================================================
	// fields
	PaintPanel _canvas = new PaintPanel();

	// creating the objects of redo class
	// =====================================================================
	// main
	public static void main(String[] args) {
		// ... Create and initialize the applet.
		JApplet theApplet = new PaintDemo();

		// ... Create a window (JFrame) and make applet the content pane.
		JFrame window = new JFrame();
		window.setContentPane(theApplet);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Paint Demo");
		window.pack();
		window.setLocationRelativeTo(null); // Center window.
		window.setResizable(true);
		// System.out.println(theApplet.getSize()); // to get applet size.
		window.setVisible(true); // Make the window visible.
	}

	// ==============================================================
	// constructor
	public PaintDemo() {
		// ... Create radio buttons for shapes.........................
		JRadioButton circleButton = new JRadioButton("Oval");
		circleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_canvas.setShape(Shape.OVAL);
			}
		});

		JRadioButton rectangleButton = new JRadioButton("Rectangle", true);
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_canvas.setShape(Shape.RECTANGLE);
			}
		});

		JRadioButton lineButton = new JRadioButton("Line");
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_canvas.setShape(Shape.LINE);
			}
		});

		ButtonGroup shapeGroup = new ButtonGroup();
		shapeGroup.add(circleButton);
		shapeGroup.add(rectangleButton);
		shapeGroup.add(lineButton);

		// --- Layout the shape buttons
		JPanel shapePanel = new JPanel();
		shapePanel.setLayout(new GridLayout(3, 1));
		shapePanel.add(circleButton);
		shapePanel.add(rectangleButton);
		shapePanel.add(lineButton);

		// ... Create radio buttons for colors...............................
		JRadioButton redButton = new JRadioButton("Red", true);
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_canvas.setColor(Color.RED);
			}
		});

		JRadioButton greenButton = new JRadioButton("Green");
		greenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_canvas.setColor(Color.GREEN);
			}
		});

		JRadioButton blueButton = new JRadioButton("Blue");
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_canvas.setColor(Color.BLUE);
			}
		});

		ButtonGroup colorGroup = new ButtonGroup();
		colorGroup.add(redButton);
		colorGroup.add(greenButton);
		colorGroup.add(blueButton);

		// ... Layout the color buttons
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(3, 1));
		colorPanel.add(redButton);
		colorPanel.add(greenButton);
		colorPanel.add(blueButton);

		// Undo Button
		JButton undo_button = new JButton("UNDO");
		undo_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				_canvas.undo();
			}
		});

		// Redo Button
		JButton redo_button = new JButton("REDO");
		redo_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				_canvas.redo();
			}
		});

		// ... Create a panel to hold the separate button panels.............
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		((Container) buttonPanel).add(shapePanel);
		buttonPanel.add(colorPanel);
		buttonPanel.add(undo_button);
		buttonPanel.add(redo_button);

		buttonPanel.add(Box.createHorizontalGlue());

		// ... layout the applet ...........................................
		setLayout(new BorderLayout(5, 5));
		add(buttonPanel, BorderLayout.NORTH);
		add(_canvas, BorderLayout.CENTER);

	}
}