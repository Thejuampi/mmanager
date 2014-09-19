package com.tj.mmanager.base.view.screen;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.view.generator.FieldGenerator;
import com.vaadin.data.util.BeanItemContainer;
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
@Component
@Scope("prototype")
public abstract class BaseSearchPanel<T extends Object> extends Panel {

    private static final long serialVersionUID = 8814637617684988536L;

    Class<T> clazz;
    Map<String, FieldGenerator> mapFieldGenerator = new HashMap<String, FieldGenerator>();

    private VerticalLayout mainLayout;
    private Label titleLabel = new Label();
    protected GridLayout filtersLayout;
    private HorizontalLayout buttonsLayout;
    private Button searchButton;
    private Button newButton;
    private Button clearButton;
    private Button closeButton;
    private Label resultsLabel = new Label();
    private Table resultsTable;

    // private static final String DEFAULT_PANEL_TITLE = "BaseSearchPanel";
    // private static final String DEFAULT_RESULTS_TITLE = "Results";

    public BaseSearchPanel(Class<T> clazz) {
	this.clazz = clazz;
	initMapFieldGenerator();
	mainLayout = buildMainLayout();
	this.addComponent(mainLayout);
	// addFieldGenerator(propertyId, fieldGenerator)
    }

    protected VerticalLayout buildMainLayout() {
	VerticalLayout layout = new VerticalLayout();
	layout.setSpacing(true);
	layout.setMargin(true);
	titleLabel.setValue(getTitlePanel());
	titleLabel.setStyleName("title");
	layout.addComponent(titleLabel);
	filtersLayout = buildFiltersLayout();
	layout.addComponent(filtersLayout);
	buttonsLayout = buildButtonsLayout();
	layout.addComponent(buttonsLayout);

	resultsLabel.setValue(getResultsTitle());
	resultsLabel.setStyleName("title");
	resultsTable = new Table();
	BeanItemContainer<?> container = getBeanItemContainer();
	resultsTable.setContainerDataSource(container);
	resultsTable.setVisibleColumns(getVisibleColumns());
	resultsTable.setColumnHeaders(getColumnHeaders());
	layout.addComponent(resultsLabel);
	layout.addComponent(resultsTable);
	return layout;
    }

    protected abstract void initMapFieldGenerator();

    protected void addFieldGenerator(String propertyId, FieldGenerator fieldGenerator) {
	mapFieldGenerator.put(propertyId, fieldGenerator);
    }

    protected GridLayout buildFiltersLayout() {
	int fieldsQty = clazz.getDeclaredFields().length;
	if (fieldsQty % 2 != 0) {
	    ++fieldsQty;
	}
	Field[] fields = clazz.getDeclaredFields();
	GridLayout layout = new GridLayout(2, fieldsQty / 2);

	for (Field field : fields) {
	    if (mapFieldGenerator.containsKey(field.getName())) {
		com.vaadin.ui.Field vaadinField = mapFieldGenerator.get(field.getName()).createField();
		layout.addComponent(vaadinField);
	    }
	}
	return layout;
    }

    /*
     * Implementar para el evento Buscar
     */
    public abstract void search();

    public abstract void close();

    public abstract void newEntity();

    public abstract void clear();

    public abstract BeanItemContainer<?> getBeanItemContainer();

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
	layoutExterno.setComponentAlignment(layoutInterno, Alignment.MIDDLE_LEFT);
	return layoutExterno;
    }

    protected abstract String[] getVisibleItemProperties();

    protected abstract String[] getColumnHeaders();

    protected abstract String[] getVisibleColumns();

    protected String getTitlePanel() {
	return "TITULO";
    }

    protected String getResultsTitle() {
	return "RESULTADOS";
    }

}
