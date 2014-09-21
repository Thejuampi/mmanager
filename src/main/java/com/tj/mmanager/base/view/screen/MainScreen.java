package com.tj.mmanager.base.view.screen;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.AbstractBean;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
public class MainScreen extends CustomComponent {

    private static final long serialVersionUID = 3924599993603881234L;

    @Autowired
    private LocalidadSearchScreen localidadSearchScreen;

    private VerticalLayout mainLayout;
    private Label labelTitulo;

    public MainScreen() {
    }
    
    @PostConstruct
    protected void init(){
    	//getApplication().setTheme("applayout");
    	this.setWidth("800px");
    	mainLayout = buildMainLayout();
    	setCompositionRoot(mainLayout);
    	//this.setLayout(mainLayout);
    }

    protected VerticalLayout buildMainLayout() {
	VerticalLayout layout = new VerticalLayout();
	layout.setWidth(100.0f, UNITS_PERCENTAGE);
	labelTitulo = new Label("MuchyManager");
	labelTitulo.setStyleName("title");
	layout.addComponent(labelTitulo);
	layout.addComponent(localidadSearchScreen);

	return layout;
    }
}
