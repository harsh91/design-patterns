package concreteproduct;

import abstractproduct.AbstractFooter;

public class WindowsFooter extends AbstractFooter {

	@Override
	public void createFooter() {
		System.out.println("Footer created by Windows Machine!!");
	}

}
