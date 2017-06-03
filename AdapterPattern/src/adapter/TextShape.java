package adapter;

import adaptee.TextView;
import target.Shape;

public class TextShape extends Shape {

	TextView textView;
	
	public TextShape(String shape) {
		textView = new TextView(shape);
	}
	
	@Override
	public void setShapeType(String shapeType) {
		textView.setShapeType(shapeType);
		super.shape = textView.getShapeType();
	}

	@Override
	public String getShapeType() {
		return super.shape;
	}

}
