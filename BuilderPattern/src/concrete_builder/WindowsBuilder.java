package concrete_builder;

import abstract_builder.AbstractBuilderPage;

public class WindowsBuilder extends AbstractBuilderPage {

	@Override
	public void createMenu() {
		page.setMenu("Menu created by Windows Machine!!");
	}

	@Override
	public void createTitleBar() {
		page.setTitleBar("TitleBar created by Windows Machine!!");
	}
	
}