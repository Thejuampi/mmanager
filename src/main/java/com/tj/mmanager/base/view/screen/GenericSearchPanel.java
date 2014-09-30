package com.tj.mmanager.base.view.screen;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import com.tj.mmanager.base.persistence.filter.GenericFilter;
import com.tj.mmanager.base.view.generator.TjDefaultFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TableFieldFactory;
import com.vaadin.ui.VerticalLayout;

/*
 * Para establecer los titulos hay que sobreescribir @getTitlePanel() y @getResultsTitle()
 */

public abstract class GenericSearchPanel<BEAN , FILTER extends GenericFilter<PK>, PK extends Serializable> extends Panel
		implements Serializable {

	private static final long serialVersionUID = 8814637617684988536L;

	private FILTER searchBean;
	
	private TjDefaultFieldFactory fieldFactory = new TjDefaultFieldFactory();

	private VerticalLayout mainLayout;
	private Label titleLabel = new Label();
	protected Form form;
	private HorizontalLayout buttonsLayout;
	private Button searchButton;
	private Button newButton;
	private Button clearButton;
	private Button closeButton;
	private Label resultsLabel = new Label();
	private Table resultsTable;

	// private static final String DEFAULT_PANEL_TITLE = "BaseSearchPanel";
	// private static final String DEFAULT_RESULTS_TITLE = "Results";

	public GenericSearchPanel() {
		
	}
	
	@PostConstruct
	protected void init(){
		mainLayout = buildMainLayout();
		this.addComponent(mainLayout);
		afterInit();
	}

	private void afterInit() {
		
	}

	protected VerticalLayout buildMainLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		titleLabel.setValue(getTitlePanel());
		titleLabel.setStyleName("title");
		layout.addComponent(titleLabel);
		form = buildForm();
		layout.addComponent(form);
		buttonsLayout = buildButtonsLayout();
		layout.addComponent(buttonsLayout);

		resultsLabel.setValue(getResultsTitle());
		resultsLabel.setStyleName("title");
		resultsTable = new Table();
		BeanItemContainer<?> container = getBeanItemContainer();
		resultsTable.setContainerDataSource(container);
		resultsTable.setVisibleColumns(getVisibleColumns());
		resultsTable.setColumnHeaders(getColumnHeaders());
		resultsTable.setSelectable(true);
		resultsTable.setWidth("95%");
		layout.addComponent(resultsLabel);
		layout.addComponent(resultsTable);
		layout.setComponentAlignment(resultsTable, Alignment.MIDDLE_CENTER);
		return layout;
	}

	@SuppressWarnings("unchecked")
	protected void reloadResultsTable(BeanItemContainer<BEAN> container,
			boolean reload) {
		resultsTable.setVisibleColumns(getVisibleColumns());
		resultsTable.setColumnHeaders(getColumnHeaders());
		if (reload) {
			resultsTable.removeAllItems();
			resultsTable.setContainerDataSource(container);
		} else {
			BeanItemContainer<BEAN> tableDataSource = (BeanItemContainer<BEAN>) resultsTable
					.getContainerDataSource();
			tableDataSource.addAll(container.getItemIds());
		}
	}

	@SuppressWarnings("unchecked")
	protected void reloadResultsTable(List<BEAN> beans, boolean reload) {
		resultsTable.setVisibleColumns(getVisibleColumns());
		resultsTable.setColumnHeaders(getColumnHeaders());
		BeanItemContainer<BEAN> tableDataSource = (BeanItemContainer<BEAN>) resultsTable
				.getContainerDataSource();
		if (reload) {
			resultsTable.removeAllItems();
			tableDataSource.addAll(beans);
		} else {
			tableDataSource.addAll(beans);
		}
	}

	protected abstract FILTER getSearchBean();

	protected Form buildForm() {

		loadFormFieldFactories();
		loadTableFormFieldFactories();
		Form form = new Form(null, fieldFactory);
		searchBean = getSearchBean();
		BeanItem<FILTER> item = new BeanItem<FILTER>(searchBean, getVisibleFormFields());
		// Item item = new BeanItem<T>
		form.setItemDataSource(item);

		return form;
	}

	/*
	 * Implementar para el evento Buscar
	 */
	public abstract void search(FILTER filter);

	public void close() {
		if (getParent() != null) {
			ComponentContainer container = (ComponentContainer) getParent();
			container.removeComponent(this);
		}
		afterClose();
	}

	/**
	 * Por defecto, cuando se presiona el boton cerrar se cierra la ventana,
	 * pero si se quiere, se pueden realizar otras tareas luego de su cierre
	 * implementando este método
	 */
	public abstract void afterClose();

	public abstract void newEntity();
	
	public void resetForm(){
		searchBean = getSearchBean();
		form.discard();
	}

	protected void clear(){
		resetForm();
		afterClear();
	}
	
//	@Lookup
//	protected abstract GenericFormPanel<?> getNewForm();
	
	protected abstract void afterClear();

	public abstract BeanItemContainer<? extends BEAN> getBeanItemContainer();

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
				search(searchBean);
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
				for (Object propertyId : form.getItemPropertyIds()) {
					form.getField(propertyId).setValue(null);
				}

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
		layoutExterno.setWidth("100%");
		layoutExterno.addComponent(layoutInterno);
		layoutExterno.setComponentAlignment(layoutInterno,
				Alignment.MIDDLE_RIGHT);
		return layoutExterno;
	}

	@SuppressWarnings("unchecked")
	protected FILTER getFormData() {
		BeanItem<FILTER> beanItem = (BeanItem<FILTER>) form.getItemDataSource();
		return beanItem.getBean();
	}

	protected abstract String[] getVisibleFormFields();

	protected abstract String[] getColumnHeaders();

	protected abstract String[] getVisibleColumns();

	protected String getTitlePanel() {
		return "TITULO";
	}

	protected String getResultsTitle() {
		return "RESULTADOS";
	}
	
	/**
	 * Si se hace un override de esta funcion se van a cargar los fieldFactories
	 * en el constructor
	 */
	protected void loadFormFieldFactories() {
		
	}
	
	protected void loadTableFormFieldFactories(){
		
	}

	protected void addFormFieldFactory(Object propertyId,
			FormFieldFactory fieldFactory) {
		this.fieldFactory.addFormFieldFactory(propertyId, fieldFactory);
	}
	/**
	 * 
	 * @param propertyId id de la propiedad
	 * @param fieldFactory el fieldFactory asociado al propertyId.
	 */
	protected void addTableFieldFactory(Object propertyId, TableFieldFactory fieldFactory){
		this.fieldFactory.addTableFieldFactory(propertyId, fieldFactory);
	}

}
