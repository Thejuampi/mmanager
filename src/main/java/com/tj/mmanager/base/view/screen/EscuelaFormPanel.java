package com.tj.mmanager.base.view.screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.bussines.service.EscuelaService;
import com.tj.mmanager.base.domain.model.Escuela;
import com.tj.mmanager.base.view.generator.LocalidadComboGenerator;

@Component
@Scope("prototype")
public class EscuelaFormPanel extends GenericFormPanel<Escuela> {

	private static final long serialVersionUID = 1L;

	private final static String[] VISIBLE_PROPERTIES = new String[]{ Escuela.Atributos.LOCALIDAD, Escuela.Atributos.NOMBRE, Escuela.Atributos.NUMERO, Escuela.Atributos.DIRECCION, Escuela.Atributos.TELEFONO, Escuela.Atributos.EMAIL }; 

	@Autowired
	private EscuelaService service;
	
	@Autowired
	private LocalidadComboGenerator localidadComboGenerator;
	
	@Override
	protected Escuela initBean() {
		return new Escuela();
	}

	@Override
	protected String[] getVisibleProperties() {
		return VISIBLE_PROPERTIES;
	}

	@Override
	protected String getWindowTitle() {
		return "Escuela";
	}

	@Override
	protected void aceptar(Escuela bean) {
		if(bean.getId() == null)
			service.saveEntity(bean);
		else
			service.updateEntity(bean);
		
	}

	@Override
	protected void cancelar(Escuela bean) {
		
	}
	
	@Override
	protected void loadFormFieldFactories() {
		addFormFieldFactory(Escuela.Atributos.LOCALIDAD, localidadComboGenerator);
	}

}
