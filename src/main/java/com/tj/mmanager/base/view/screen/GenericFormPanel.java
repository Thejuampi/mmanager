package com.tj.mmanager.base.view.screen;

import java.util.Collection;

import javax.annotation.PostConstruct;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public abstract class GenericFormPanel<T extends Object> extends Form {
	
	private static final long serialVersionUID = -1416600404416900271L;

	private BeanItem<T> beanItem;
	
	private HorizontalLayout botonesLayout;
	
	Button aceptarButton;
	
	Button cancelarButton;
	
	T bean = initBean();
	
	public GenericFormPanel(){
		
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
	
	@PostConstruct
	public void init(){
		this.setItemDataSource(getBeanItem());
		aceptarButton = new Button("Aceptar", new Button.ClickListener() {

			private static final long serialVersionUID = -245537330785691498L;

			@Override
			public void buttonClick(ClickEvent event) {
				commit();
				aceptar(bean);
			}
		});
		cancelarButton = new Button("Cancelar", new Button.ClickListener() {
			
			private static final long serialVersionUID = 4440529822842883414L;

			@Override
			public void buttonClick(ClickEvent event) {
				commit();
				cancelar(bean);
			}
		});
		
		botonesLayout.addComponent(aceptarButton);
		botonesLayout.addComponent(cancelarButton);
		setFooter(botonesLayout);
	}
	
	public Window createWindow(){
		Window window = new Window(getWindowTitle());
		window.setModal(true);
		window.addComponent(this);
		
		return window;
	}
	
}
