package concreteproduct;

import abstractproduct.AbstractFooter;

public class LinuxFooter extends AbstractFooter {

	@Override
	public void createFooter() {
		System.out.println("Footer created by Linux Machine!!");
	}

}
