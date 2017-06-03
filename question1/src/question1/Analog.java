package question1;

import java.util.Date;

public class Analog extends Component {
	
	public Analog(Strategy strategy) {
		super(strategy);
		this.draw();
		strategy.decide();
	}
	
	@Override
	public void draw() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Analog");
		System.out.println(new Date());
	}

}