package question1;

import java.util.Date;

public class Digital  extends Component {
	
	public Digital(Strategy strategy) {
		super(strategy);
		this.draw();
		strategy.decide();
	}
	
	@Override
	public void draw() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Digital");
		System.out.println(new Date());
	}

}
