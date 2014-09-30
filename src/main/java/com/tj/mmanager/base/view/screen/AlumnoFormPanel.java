package com.tj.mmanager.base.view.screen;

import org.springframework.beans.factory.annotation.Autowired;

import com.tj.mmanager.base.bussines.service.AlumnoService;
import com.tj.mmanager.base.domain.model.Alumno;

public class AlumnoFormPanel extends GenericFormPanel<Alumno> {

	private static final long serialVersionUID = -8269760230511747158L;

	static final String[] VISIBLE_PROPERTIES = new String[] {Alumno.Atributos.ESCUELA, Alumno.Atributos.APELLIDO, Alumno.Atributos.NOMBRE, Alumno.Atributos.DIVISION_ACTUAL, Alumno.Atributos.DIVISIONES, Alumno.Atributos.DETALLES_ELEMENTOS_EVALUABLES};

	@Autowired
	private AlumnoService service;
	
	@Override
	protected Alumno initBean() {
		return new Alumno();
	}

	@Override
	protected String[] getVisibleProperties() {
		return VISIBLE_PROPERTIES;
	}

	@Override
	protected String getWindowTitle() {
		return "Alumno";
	}

	@Override
	protected void aceptar(Alumno bean) {
		if(bean.getId() == null)
			service.saveEntity(bean);
		else
			service.updateEntity(bean);
	}

	@Override
	protected void cancelar(Alumno bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loadFormFieldFactories() {
		//TODO crear los FieldFactories
	}

}
