package client;

import adapter.LineShape;
import adapter.TextShape;
import target.Shape;

public class Editor {

	public static void main(String[] args) {
		Shape lineShape = new LineShape();
		lineShape.setShapeType("Straight");
		System.out.println(lineShape.getShapeType());
		
		Shape textShape = new TextShape("Cursive");
		textShape.setShapeType("Text Shape");
		System.out.println(textShape.getShapeType());
	}

}
