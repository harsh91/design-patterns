package question1;

public class DecoratorOne extends Component {
	
	public DecoratorOne(Component component) {
		super(component);
		draw();
	}
	
	@Override
	public void draw() {
		System.out.println("Decorator One");
	}

}
