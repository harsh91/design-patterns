package client;

import concretefactory.LinuxFactory;
import concretefactory.WindowsFactory;
import abstractproduct.AbstractFooter;
import abstractproduct.AbstractMenu;
import abtsractfactory.AbstractWidgetFactory;

public class Client {

	public Client(AbstractWidgetFactory factory) {
		AbstractMenu abstractMenu = factory.createMenu();
		abstractMenu.createMenu();
		AbstractFooter abstractFooter = factory.createFooter();
		abstractFooter.createFooter();
	}
	
	public static void main(String[] args) {
		new Client(new LinuxFactory());
		new Client(new WindowsFactory());
	}

}
