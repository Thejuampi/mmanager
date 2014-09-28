package com.tj.mmanager.base.view.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.tj.mmanager.base.bussines.service.LocalidadService;
import com.tj.mmanager.base.domain.model.Localidad;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;

@org.springframework.stereotype.Component
@Scope("singleton")
public class LocalidadComboGenerator implements FormFieldFactory {

	private static final long serialVersionUID = -4043981511926199945L;
	@Autowired
	LocalidadService service;
	
	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		BeanItemContainer<Localidad> container = new BeanItemContainer<Localidad>(Localidad.class, service.findAll());
		ComboBox box = new ComboBox();
		box.setItemCaptionPropertyId(Localidad.Atributos.NOMBRE);
		box.setContainerDataSource(container);
		return box;
	}

}
