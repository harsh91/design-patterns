package question1;

public class Client {

	public static void main(String[] args) {
		new DecoratorOne(new Analog(new StrategyOne()));
		new DecoratorOne(new DecoratorTwo(new Analog(new StrategyOne())));
		new DecoratorTwo(new Analog(new StrategyOne()));
		new DecoratorTwo(new DecoratorOne(new Analog(new StrategyOne())));
		
		new DecoratorOne(new Digital(new StrategyOne()));
		new DecoratorOne(new DecoratorTwo(new Digital(new StrategyOne())));
		new DecoratorTwo(new Digital(new StrategyOne()));
		new DecoratorTwo(new DecoratorOne(new Digital(new StrategyOne())));
		
		new DecoratorOne(new Analog(new StrategyTwo()));
		new DecoratorOne(new DecoratorTwo(new Analog(new StrategyTwo())));
		new DecoratorTwo(new Analog(new StrategyTwo()));
		new DecoratorTwo(new DecoratorOne(new Analog(new StrategyTwo())));
		
		new DecoratorOne(new Digital(new StrategyTwo()));
		new DecoratorOne(new DecoratorTwo(new Digital(new StrategyTwo())));
		new DecoratorTwo(new Digital(new StrategyTwo()));
		new DecoratorTwo(new DecoratorOne(new Digital(new StrategyTwo())));
	}

}
