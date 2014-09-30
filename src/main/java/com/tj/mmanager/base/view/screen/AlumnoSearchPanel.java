package com.tj.mmanager.base.view.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.bussines.service.AlumnoService;
import com.tj.mmanager.base.domain.model.Alumno;
import com.tj.mmanager.base.domain.model.Curso;
import com.tj.mmanager.base.domain.model.Division;
import com.tj.mmanager.base.domain.model.Escuela;
import com.tj.mmanager.base.persistence.filter.AlumnoFilter;
import com.tj.mmanager.base.view.generator.EscuelasComboGenerator;
import com.vaadin.data.util.BeanItemContainer;

@Component
@Scope("prototype")
public class AlumnoSearchPanel extends GenericSearchPanel<Alumno,AlumnoFilter,Long> {

	private static final long serialVersionUID = -7441120772587077193L;
	
	private static final String[] VISIBLE_FORM_FIELDS = new String[]{ Alumno.Atributos.ESCUELA, Alumno.Atributos.APELLIDO, Alumno.Atributos.NOMBRE, Alumno.Atributos.DIVISION_ACTUAL };
	
	static final String[] VISIBLE_COLUMNS = new String[] { Alumno.Atributos.ESCUELA+"."+Escuela.Atributos.NOMBRE, Alumno.Atributos.APELLIDO, Alumno.Atributos.NOMBRE, Alumno.Atributos.DIVISION_ACTUAL+"."+Division.Atributos.CURSO+"."+Curso.Atributos.NOMBRE, Alumno.Atributos.DIVISION_ACTUAL+"."+Division.Atributos.NOMBRE };
	
	static final String[] COLUMN_HEADERS = new String[]{ "Escuela", "Nombre", "Apellido", "Curso", "División" };
	
	@Autowired
	private AlumnoService service;
	
	@Autowired
	AlumnoFormPanel form;
	
	@Autowired
	EscuelasComboGenerator escuelaGenerator;
	
	@Override
	protected AlumnoFilter getSearchBean() {
		return new AlumnoFilter();
	}

	@Override
	public void search(AlumnoFilter filter) {
		List<Alumno> alumnos = service.filter(filter);
		reloadResultsTable(alumnos, true);
	}

	@Override
	public void afterClose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newEntity() {
		getApplication().getMainWindow().addWindow(getNewForm().createWindow());	
	}

	@Lookup("alumnoFormPanel")
	private AlumnoFormPanel getNewForm() {
		return form;
	}

	@Override
	protected void afterClear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BeanItemContainer<? extends Alumno> getBeanItemContainer() {
		BeanItemContainer<Alumno> container = new BeanItemContainer<Alumno>(Alumno.class);
		container.removeContainerProperty(Alumno.Atributos.DETALLES_ELEMENTOS_EVALUABLES);
		container.removeContainerProperty(Alumno.Atributos.DIVISIONES);
		container.removeContainerProperty(Alumno.Atributos.ESCUELA);
		//Escuela
		container.addNestedContainerProperty(Alumno.Atributos.ESCUELA+"."+Escuela.Atributos.NOMBRE);
		//Division
		container.addNestedContainerProperty(Alumno.Atributos.DIVISION_ACTUAL+"."+Division.Atributos.NOMBRE);
		//Curso
		container.addNestedContainerProperty(Alumno.Atributos.DIVISION_ACTUAL+"."+Division.Atributos.CURSO+"."+Curso.Atributos.NOMBRE);
		
		return container;
	}

	@Override
	protected String[] getVisibleFormFields() {
		return VISIBLE_FORM_FIELDS;
	}

	@Override
	protected String[] getColumnHeaders() {
		return COLUMN_HEADERS;
	}

	@Override
	protected String[] getVisibleColumns() {
		return VISIBLE_COLUMNS;
	}
	
	@Override
	protected void loadFormFieldFactories() {
		addFormFieldFactory(Alumno.Atributos.ESCUELA, escuelaGenerator);
	}
}
