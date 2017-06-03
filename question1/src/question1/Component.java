package question1;

public abstract class Component {

	public Component(Component component) {}

	public Component(Strategy strategy) {}

	public abstract void draw();
	
}
