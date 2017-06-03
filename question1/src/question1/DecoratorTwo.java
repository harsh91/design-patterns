package question1;

public class DecoratorTwo extends Component {
	
	public DecoratorTwo(Component component) {
		super(component);
		draw();
	}
	
	@Override
	public void draw() {
		System.out.println("Decorator Two");
	}
	
}
