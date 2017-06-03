package concrete_builder;

import abstract_builder.AbstractBuilderPage;

public class LinuxBuilder extends AbstractBuilderPage {

	@Override
	public void createMenu() {
		page.setMenu("Menu by Linux Machine!!");
	}

	@Override
	public void createTitleBar() {
		page.setTitleBar("TitleBar by Linux Machine!!");
	}

}
