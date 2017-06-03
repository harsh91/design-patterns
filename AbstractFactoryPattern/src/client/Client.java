package client;

import abstractproduct.AbstractFooter;
import abstractproduct.AbstractMenu;
import abtsractfactory.AbstractWidgetFactory;

public class Client {

	public Client(String factoryName) {
		AbstractWidgetFactory abstractFactory = AbstractWidgetFactory.getFactory(factoryName);
		AbstractMenu abstractMenu = abstractFactory.createMenu();
		abstractMenu.createMenu();
		AbstractFooter abstractFooter = abstractFactory.createFooter();
		abstractFooter.createFooter();
	}
	
	public static void main(String[] args) {
		new Client("Linux");
		new Client("Windows");
	}

}
