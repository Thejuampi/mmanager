package com.tj.mmanager.base.view.screen;

import com.tj.mmanager.base.domain.model.Localidad;

public class LocalidadFormPanel extends GenericFormPanel<Localidad> {
	
	private static final long serialVersionUID = -7777318772463117213L;
	private static final String[] VISIBLE_PROPERTIES = new String[]{ Localidad.Atributos.NOMBRE };

	@Override
	protected Localidad initBean() {
		return new Localidad();
	}

	@Override
	protected String[] getVisibleProperties() {
		return VISIBLE_PROPERTIES;
	}

}
