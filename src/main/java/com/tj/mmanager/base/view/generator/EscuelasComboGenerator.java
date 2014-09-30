package com.tj.mmanager.base.view.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.tj.mmanager.base.bussines.service.EscuelaService;
import com.tj.mmanager.base.domain.model.Escuela;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;

@org.springframework.stereotype.Component
@Scope("singleton")
public class EscuelasComboGenerator implements FormFieldFactory {

	private static final long serialVersionUID = -1686327594535398795L;
	
	@Autowired
	private EscuelaService service;

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		ComboBox box = new ComboBox();
		BeanItemContainer<Escuela> container = new BeanItemContainer<Escuela>(Escuela.class, service.findAll());
		box.setContainerDataSource(container);
		box.setItemCaptionPropertyId(Escuela.Atributos.NOMBRE);
		return box;
	}

}
