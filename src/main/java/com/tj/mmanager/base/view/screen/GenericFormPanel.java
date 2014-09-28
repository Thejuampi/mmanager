package com.tj.mmanager.base.view.screen;

import javax.annotation.PostConstruct;

import com.tj.mmanager.base.view.generator.TjDefaultFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public abstract class GenericFormPanel<T extends Object> extends Form {

	private static final long serialVersionUID = -1416600404416900271L;

	private BeanItem<T> beanItem;

	private HorizontalLayout botonesLayout = new HorizontalLayout();

	Button aceptarButton;

	Button cancelarButton;

	Window formWindow;

	private TjDefaultFieldFactory fieldFactory = new TjDefaultFieldFactory();

	T bean = initBean();

	public GenericFormPanel() {
		super();
	}

	protected abstract T initBean();

	protected abstract String[] getVisibleProperties();

	protected abstract String getWindowTitle();

	protected abstract void aceptar(T bean);

	protected abstract void cancelar(T bean);

	public BeanItem<T> getBeanItem() {
		beanItem = new BeanItem<T>(bean, getVisibleProperties());
		return beanItem;
	}

	public T getbean() {
		return beanItem.getBean();
	}

	@PostConstruct
	public void init() {
		bean = initBean();
		loadFormFieldFactories();
		setFormFieldFactory(fieldFactory);
		this.setItemDataSource(getBeanItem());
		aceptarButton = new Button("Aceptar", new Button.ClickListener() {

			private static final long serialVersionUID = -245537330785691498L;

			@Override
			public void buttonClick(ClickEvent event) {
				commit();
				aceptar(bean);
				closeWindow();
			}
		});
		cancelarButton = new Button("Cerrar", new Button.ClickListener() {

			private static final long serialVersionUID = 4440529822842883414L;

			@Override
			public void buttonClick(ClickEvent event) {
				commit();
				cancelar(bean);
				closeWindow();
			}
		});

		botonesLayout.addComponent(aceptarButton);
		botonesLayout.addComponent(cancelarButton);
		botonesLayout.setWidth("100%");
		botonesLayout.setMargin(true);
		botonesLayout.setSpacing(true);
		HorizontalLayout outerLayout = new HorizontalLayout();
		outerLayout.setSizeUndefined();
		outerLayout.addComponent(botonesLayout);
		outerLayout
				.setComponentAlignment(botonesLayout, Alignment.MIDDLE_RIGHT);
		setFooter(outerLayout);
	}

	public Window createWindow() {
		formWindow = new Window(getWindowTitle());
		formWindow.setModal(true);
		formWindow.setWidth(getWindowWidgth());
		formWindow.addComponent(this);

		return formWindow;
	}

	/**
	 * cierra la ventana
	 */
	public void closeWindow() {
		if (formWindow.getParent() != null) {
			formWindow.getParent().removeWindow(formWindow);
		}
		bean = initBean();
	}

	/**
	 * Si la ventana esta contenida dentro de otro window 'parent'
	 * 
	 * @param parent
	 *            la ventana padre
	 */
	public void closeWindow(Window parent) {
		if (parent.getChildWindows().contains(formWindow)) {
			parent.removeWindow(formWindow);
		}
		bean=initBean();
	}

	/**
	 * Si se hace un override de esta funcion se van a cargar los fieldFactories
	 * en el constructor
	 */
	protected void loadFormFieldFactories() {

	}

	protected void addFormFieldFactory(Object propertyId,
			FormFieldFactory fieldFactory) {
		this.fieldFactory.addFormFieldFactory(propertyId, fieldFactory);
	}

	public String getWindowWidgth() {
		return "450px";
	}

}
