package abtsractfactory;

import abstractproduct.AbstractFooter;
import abstractproduct.AbstractMenu;
import concretefactory.LinuxFactory;
import concretefactory.WindowsFactory;

public abstract class AbstractWidgetFactory {

	private static final String LINUX_FACTORY = "Linux";
	private static final String WINDOWS_FACTORY = "Windows";
	
	public static AbstractWidgetFactory getFactory(String factoryName) {
		if(factoryName.equals(LINUX_FACTORY)) {
			return new LinuxFactory();
		} else if(factoryName.equals(WINDOWS_FACTORY)) {
			return new WindowsFactory();
		} else {
			return null;
		}
	}
	
	public abstract AbstractFooter createFooter();
	
	public abstract AbstractMenu createMenu();
	
}
