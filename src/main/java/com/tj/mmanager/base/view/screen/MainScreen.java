package com.tj.mmanager.base.view.screen;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Component
@Scope("request")
public class MainScreen extends CustomComponent {

	private static final long serialVersionUID = 3924599993603881234L;

	@Autowired
	private LocalidadSearchScreen localidadSearchScreen;
	
	@Autowired
	private EscuelaSearchScreen escuelaSearchScreen;
	
	@Autowired
	private AlumnoSearchPanel alumnoSearchPanel;

	private VerticalLayout mainLayout;
	private Label labelTitulo;

	GenericSearchPanel<?,?,?> searchPanelActual=null;

	private Button localidadSearchButton;
	private Button escuelaSearchButton;
	private Button alumnoSearchButton;

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
		escuelaSearchButton = buildEscuelaSearchButton();
		alumnoSearchButton = buildAlumnoSearchButton();

		GridLayout grillaBotones = new GridLayout(2, 2);
		grillaBotones.addComponent(localidadSearchButton);
		grillaBotones.addComponent(escuelaSearchButton);
		grillaBotones.addComponent(alumnoSearchButton);
		
		layout.addComponent(grillaBotones);

		return layout;
	}

	private Button buildAlumnoSearchButton() {
		Button boton = new Button("Alumnos", new Button.ClickListener() {

			private static final long serialVersionUID = -5230486086438197334L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (searchPanelActual != null) {
					mainLayout.removeComponent(searchPanelActual);					
				}
				AlumnoSearchPanel asp = getAlumnoSearchPanel();
				mainLayout.addComponent(asp);
				searchPanelActual = asp;
			}
		});
		return boton;
	}

	private Button buildEscuelaSearchButton() {
		Button boton = new Button("Escuelas", new Button.ClickListener() {

			private static final long serialVersionUID = -5230486086438197334L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (searchPanelActual != null) {
					mainLayout.removeComponent(searchPanelActual);					
				}
				EscuelaSearchScreen ess = getEscuelaSearchScreen();
				mainLayout.addComponent(ess);
				searchPanelActual = ess;
			}
		});
		return boton;
	}

	private Button buildLocalidadSearchButton() {
		Button boton = new Button("Localidades", new Button.ClickListener() {

			private static final long serialVersionUID = -1560077881803034447L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (searchPanelActual != null) {
					mainLayout.removeComponent(searchPanelActual);					
				}
				LocalidadSearchScreen lss = getLocalidadSearchScreen();
				mainLayout.addComponent(lss);
				searchPanelActual = lss;
			}
		});
		return boton;
	}
	
	@Lookup
	LocalidadSearchScreen getLocalidadSearchScreen(){
		return localidadSearchScreen;
	}
	
	@Lookup
	EscuelaSearchScreen getEscuelaSearchScreen(){
		return escuelaSearchScreen;
	}
	
	@Lookup("alumnoSearchPanel")
	protected AlumnoSearchPanel getAlumnoSearchPanel() {
		return alumnoSearchPanel;
	}
}
