package client;

import generic_components.Page;
import concrete_builder.LinuxBuilder;
import concrete_builder.WindowsBuilder;
import construct_product.PageCreator;

public class Client {
	
	public static void main(String[] args) {
		PageCreator pageCreator = new PageCreator();
		
//		LinuxBuilder linuxBuilder = new LinuxBuilder();
//		pageCreator.setBuilderPage(linuxBuilder);
		
		WindowsBuilder windowsBuilder = new WindowsBuilder();
		pageCreator.setBuilderPage(windowsBuilder);
		
		pageCreator.constructPage();
		
		Page page = pageCreator.getPage();
		System.out.println(page.getMenu());
		System.out.println(page.getTitleBar());
	}

}
