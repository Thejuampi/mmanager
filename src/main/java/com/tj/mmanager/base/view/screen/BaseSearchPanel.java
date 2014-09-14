package com.tj.mmanager.base.view.screen;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/*
 * Para establecer los titulos hay que sobreescribir @getTitlePanel() y @getResultsTitle()
 */
public abstract class BaseSearchPanel<BEAN> extends Panel {

    private static final long serialVersionUID = 8814637617684988536L;

    private VerticalLayout mainLayout;
    private Label titleLabel;
    private GridLayout filtersLayout;
    private HorizontalLayout buttonsLayout;
    private Button searchButton;
    private Button newButton;
    private Button clearButton;
    private Button closeButton;
    private Label resultsLabel;
    private Table resultsTable;

    // private static final String DEFAULT_PANEL_TITLE = "BaseSearchPanel";
    // private static final String DEFAULT_RESULTS_TITLE = "Results";

    public BaseSearchPanel() {
	mainLayout = buildMainLayout();
	this.addComponent(mainLayout);
    }

    protected VerticalLayout buildMainLayout() {
	VerticalLayout layout = new VerticalLayout();
	titleLabel.setValue(getTitlePanel());
	layout.addComponent(titleLabel);
	filtersLayout = buildFiltersLayout();
	layout.addComponent(filtersLayout);
	buttonsLayout = buildButtonsLayout();
	layout.addComponent(buttonsLayout);

	resultsLabel.setValue(getResultsTitle());
	resultsTable = new Table();
	layout.addComponent(resultsLabel);
	layout.addComponent(resultsTable);
	return layout;
    }

    protected GridLayout buildFiltersLayout() {
	GridLayout layout = new GridLayout();

	return layout;
    }

    /*
     * Implementar para el evento Buscar
     */
    public abstract void search();

    public abstract void close();

    public abstract void newEntity();

    public abstract void clear();

    protected HorizontalLayout buildButtonsLayout() {
	HorizontalLayout layoutInterno = new HorizontalLayout();
	layoutInterno.setSpacing(true);
	this.searchButton = new Button("Buscar");
	this.newButton = new Button("Nuevo");
	this.clearButton = new Button("Limpiar Filtros");
	this.closeButton = new Button("Cerrar");

	searchButton.addListener(new ClickListener() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public void buttonClick(ClickEvent event) {
		search();
	    }
	});

	newButton.addListener(new ClickListener() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public void buttonClick(ClickEvent event) {
		newEntity();
	    }
	});

	clearButton.addListener(new ClickListener() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public void buttonClick(ClickEvent event) {
		clear();
	    }
	});

	closeButton.addListener(new ClickListener() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public void buttonClick(ClickEvent event) {
		close();
	    }
	});
	layoutInterno.addComponent(searchButton);
	layoutInterno.addComponent(newButton);
	layoutInterno.addComponent(clearButton);
	layoutInterno.addComponent(closeButton);

	HorizontalLayout layoutExterno = new HorizontalLayout();
	layoutExterno.addComponent(layoutInterno);
	layoutExterno.setComponentAlignment(layoutInterno, Alignment.MIDDLE_RIGHT);
	return layoutExterno;
    }

    protected abstract String getTitlePanel();

    protected abstract String getResultsTitle();

}
