package com.tj.mmanager.base.view.screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.bussines.service.LocalidadService;
import com.tj.mmanager.base.domain.model.Localidad;

@Component
@Scope("prototype")
public class LocalidadFormPanel extends GenericFormPanel<Localidad> {
	
	private static final long serialVersionUID = -7777318772463117213L;
	private static final String[] VISIBLE_PROPERTIES = new String[]{ Localidad.Atributos.NOMBRE };
	
	@Autowired
	LocalidadService service;

	@Override
	protected Localidad initBean() {
		return new Localidad();
	}

	@Override
	protected String[] getVisibleProperties() {
		return VISIBLE_PROPERTIES;
	}

	@Override
	protected String getWindowTitle() {
		return "Localidad Form Panel";
	}

	@Override
	protected void aceptar(Localidad bean) {
		if(bean.getId() == null)
			service.saveEntity(bean);
		else
			service.updateEntity(bean);
	}

	@Override
	protected void cancelar(Localidad bean) {
	}

	@Override
	public void loadFormFieldFactories() {
	
	}

}
