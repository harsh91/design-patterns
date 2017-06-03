package adaptee;

public class TextView {
	
	private String shape;
	
	public TextView(String shape) {
		this.shape = shape;
	}
	
	public void setShapeType(String shapeType) {
		shape = "Exact shape from TextView : " + shapeType;
	}
	
	public String getShapeType() {
		return shape;
	}
}
