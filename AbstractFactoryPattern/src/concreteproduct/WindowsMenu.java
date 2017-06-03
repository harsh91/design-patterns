package concreteproduct;

import abstractproduct.AbstractMenu;

public class WindowsMenu extends AbstractMenu {

	@Override
	public void createMenu() {
		System.out.println("Menu created by Windows Machine!!");
	}

}
