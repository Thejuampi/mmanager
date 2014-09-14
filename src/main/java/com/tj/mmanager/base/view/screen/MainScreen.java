package com.tj.mmanager.base.view.screen;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class MainScreen extends CustomComponent {

    private static final long serialVersionUID = 3924599993603881234L;
    
    private VerticalLayout mainLayout;
    
    public MainScreen() {
	mainLayout = buildMainLayout();
	setCompositionRoot(mainLayout);
    }
    
    protected VerticalLayout buildMainLayout(){
	VerticalLayout layout = new VerticalLayout();
	return layout;
    }
    

}
