package concreteproduct;

import abstractproduct.AbstractMenu;

public class LinuxMenu extends AbstractMenu {

	@Override
	public void createMenu() {
		System.out.println("Menu created by Linux Machine!!");
	}

}
