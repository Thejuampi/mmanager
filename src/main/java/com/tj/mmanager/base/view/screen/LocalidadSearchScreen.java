package com.tj.mmanager.base.view.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.bussines.service.LocalidadService;
import com.tj.mmanager.base.domain.model.Localidad;
import com.tj.mmanager.base.persistence.filter.LocalidadFilter;
import com.vaadin.data.util.BeanItemContainer;

@Component
@Scope("prototype")
public class LocalidadSearchScreen extends GenericSearchPanel<Localidad, LocalidadFilter, Long> {

	private static final long serialVersionUID = 4870452614299228051L;

	static final String[] VISIBLE_ITEM_PROPERTIES = new String[] { Localidad.Atributos.NOMBRE };
	static final String[] COLUMN_HEADERS = new String[] { Localidad.Atributos.NOMBRE };
	static final String[] VISIBLE_COLUMNS = new String[] { Localidad.Atributos.NOMBRE };

	@Autowired
	LocalidadService service;

	@Autowired
	LocalidadFormPanel form;

	@Override
	public void search(LocalidadFilter filter) {
		List<Localidad> localidades = service.filter(filter);
		reloadResultsTable(localidades, true);
	}

	@Lookup
	public LocalidadFormPanel getNewForm() {
		return form;
	}

	@Override
	public void afterClose() {

	}

	@Override
	public void newEntity() {
		getApplication().getMainWindow().addWindow(getNewForm().createWindow());
	}

	@Override
	public BeanItemContainer<Localidad> getBeanItemContainer() {
		BeanItemContainer<Localidad> container = new BeanItemContainer<Localidad>(
				Localidad.class);
		return container;
	}

	@Override
	protected String getTitlePanel() {
		return "Panel de Busqueda de Localidades";
	}

	@Override
	protected String getResultsTitle() {
		return "Localidades";
	}

	@Override
	protected String[] getVisibleFormFields() {
		return VISIBLE_ITEM_PROPERTIES;
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
	protected LocalidadFilter getSearchBean() {
		return new LocalidadFilter();
	}

	@Override
	protected void afterClear() {
		
	}
	
	@Override
	protected void loadFormFieldFactories() {
		
	}

}
