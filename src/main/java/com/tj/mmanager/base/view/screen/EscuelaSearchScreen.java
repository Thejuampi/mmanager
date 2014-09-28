package com.tj.mmanager.base.view.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.bussines.service.EscuelaService;
import com.tj.mmanager.base.domain.model.Escuela;
import com.tj.mmanager.base.domain.model.Localidad;
import com.tj.mmanager.base.persistence.filter.EscuelaFilter;
import com.tj.mmanager.base.view.generator.LocalidadComboGenerator;
import com.vaadin.data.util.BeanItemContainer;

@Component
@Scope("prototype")
public class EscuelaSearchScreen extends GenericSearchPanel<Escuela, EscuelaFilter, Long> {

	private static final long serialVersionUID = -4176091466789161372L;
	
	private static final String[] VISIBLE_FORM_FIELDS = new String[] {Escuela.Atributos.LOCALIDAD, Escuela.Atributos.NOMBRE, Escuela.Atributos.NUMERO, Escuela.Atributos.EMAIL};
	private static final String[] COLUMN_HEADERS = new String[] {"Localidad", "Nombre", "Número", "Tel.", "e-mail"};
	private static final String[] VISIBLE_COLUMNS = new String[] {Escuela.Atributos.LOCALIDAD+"."+Localidad.Atributos.NOMBRE, Escuela.Atributos.NOMBRE, Escuela.Atributos.NUMERO, Escuela.Atributos.TELEFONO, Escuela.Atributos.EMAIL};
	
	@Autowired
	EscuelaService service;
	
	@Autowired
	EscuelaFormPanel form;
	
	@Autowired
	LocalidadComboGenerator localidadComboGenerator;
	
	@Override
	protected EscuelaFilter getSearchBean() {
		return new EscuelaFilter();
	}

	@Override
	public void search(EscuelaFilter filter) {
		List<Escuela> escuelas = service.filter(filter);
		reloadResultsTable(escuelas, true);
	}

	@Override
	public void afterClose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newEntity() {
		getApplication().getMainWindow().addWindow(getNewForm().createWindow());
	}

	@Override
	protected void afterClear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BeanItemContainer<? extends Escuela> getBeanItemContainer() {
		BeanItemContainer<Escuela> container = new BeanItemContainer<Escuela>(Escuela.class);
		container.addNestedContainerProperty("localidad.nombre");
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

	@Lookup
	protected EscuelaFormPanel getNewForm() {
		return form;
	}

	@Override
	protected void loadFormFieldFactories() {
		addFormFieldFactory(Escuela.Atributos.LOCALIDAD, localidadComboGenerator);
	}

}
