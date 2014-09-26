package com.tj.mmanager.base.view.screen;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Component
@Scope("prototype")
public class MainScreen extends CustomComponent {

	private static final long serialVersionUID = 3924599993603881234L;

	@Autowired
	private LocalidadSearchScreen localidadSearchScreen;

	private VerticalLayout mainLayout;
	private Label labelTitulo;

	GenericSearchPanel<?> searchPanelActual=null;

	private Button localidadSearchButton;

	public MainScreen() {
	}

	@PostConstruct
	protected void init() {
		this.setWidth("800px");
		mainLayout = buildMainLayout();
		setCompositionRoot(mainLayout);
	}

	protected VerticalLayout buildMainLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setWidth(100.0f, UNITS_PERCENTAGE);
		labelTitulo = new Label("mmanager");
		labelTitulo.setStyleName("title");
		layout.addComponent(labelTitulo);
		localidadSearchButton = buildLocalidadSearchButton();

		GridLayout grillaBotones = new GridLayout(2, 2);
		grillaBotones.addComponent(localidadSearchButton);
		// layout.addComponent(localidadSearchScreen);
		layout.addComponent(grillaBotones);

		return layout;
	}

	private Button buildLocalidadSearchButton() {
		Button boton = new Button("Localidades", new Button.ClickListener() {

			private static final long serialVersionUID = -5230486086438197334L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (searchPanelActual != null) {
					mainLayout.removeComponent(searchPanelActual);					
				}
				mainLayout.addComponent(localidadSearchScreen);
				searchPanelActual = localidadSearchScreen;
			}
		});
		return boton;
	}
}
