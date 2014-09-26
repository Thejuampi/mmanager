package com.tj.mmanager.base.view.screen;

import javax.annotation.PostConstruct;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
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

	T bean = initBean();

	public GenericFormPanel() {

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
		this.setItemDataSource(getBeanItem());
		aceptarButton = new Button("Aceptar", new Button.ClickListener() {

			private static final long serialVersionUID = -245537330785691498L;

			@Override
			public void buttonClick(ClickEvent event) {
				commit();
				aceptar(bean);
			}
		});
		cancelarButton = new Button("MOD", new Button.ClickListener() {

			private static final long serialVersionUID = 4440529822842883414L;

			@Override
			public void buttonClick(ClickEvent event) {
				commit();
				cancelar(bean);
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
		outerLayout.setComponentAlignment(botonesLayout, Alignment.MIDDLE_RIGHT);
		setFooter(outerLayout);
	}

	public Window createWindow() {
		formWindow = new Window(getWindowTitle());
		formWindow.setModal(true);
		formWindow.setWidth(getWindowWidgth());
		formWindow.addComponent(this);

		return formWindow;
	}

	public void closeWindow(Window parent) {
		if (parent.getChildWindows().contains(formWindow)) {
			parent.removeWindow(formWindow);
		}
	}
	
	public String getWindowWidgth(){
		return "450px";
	}

}
