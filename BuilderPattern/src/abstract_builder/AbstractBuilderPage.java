package abstract_builder;

import generic_components.Page;

public abstract class AbstractBuilderPage {
	
	public Page page;
	
	public Page getPage() { return page; }
	
	public void instantiatePageInstance() { page = new Page(); }
	
	public abstract void createMenu();
	
	public abstract void createTitleBar();

}
