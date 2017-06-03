package adapter;

import target.Shape;

public class LineShape extends Shape {

	@Override
	public void setShapeType(String shapeType) {
		super.shape = shapeType;
	}

	@Override
	public String getShapeType() {
		return super.shape;
	}

}
