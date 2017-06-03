package concretefactory;

import concreteproduct.LinuxFooter;
import concreteproduct.LinuxMenu;
import abstractproduct.AbstractFooter;
import abstractproduct.AbstractMenu;
import abtsractfactory.AbstractWidgetFactory;

public class LinuxFactory extends AbstractWidgetFactory {

	@Override
	public AbstractFooter createFooter() {
		return new LinuxFooter();
	}

	@Override
	public AbstractMenu createMenu() {
		return new LinuxMenu();
	}
	
	

}
