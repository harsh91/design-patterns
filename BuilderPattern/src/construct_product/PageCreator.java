package construct_product;

import generic_components.Page;
import abstract_builder.AbstractBuilderPage;

public class PageCreator {
	
	public AbstractBuilderPage abstractBuilderPage;
	
	public void setBuilderPage(AbstractBuilderPage builderPage) {
		abstractBuilderPage = builderPage;
	}
	
	public Page getPage() { return abstractBuilderPage.getPage(); }
	
	public void constructPage() {
		abstractBuilderPage.instantiatePageInstance();
		abstractBuilderPage.createMenu();
		abstractBuilderPage.createTitleBar();
	}

}
