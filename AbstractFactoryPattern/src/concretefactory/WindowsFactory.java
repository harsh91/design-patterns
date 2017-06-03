package concretefactory;

import concreteproduct.WindowsFooter;
import concreteproduct.WindowsMenu;
import abstractproduct.AbstractFooter;
import abstractproduct.AbstractMenu;
import abtsractfactory.AbstractWidgetFactory;

public class WindowsFactory extends AbstractWidgetFactory {

	@Override
	public AbstractFooter createFooter() {
		return new WindowsFooter();
	}

	@Override
	public AbstractMenu createMenu() {
		// TODO Auto-generated method stub
		return new WindowsMenu();
	}

}
