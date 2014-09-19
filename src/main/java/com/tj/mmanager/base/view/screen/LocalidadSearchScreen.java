package com.tj.mmanager.base.view.screen;

import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.tj.mmanager.base.domain.model.Localidad;
import com.tj.mmanager.base.view.generator.FieldGenerator;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

@Component
public class LocalidadSearchScreen extends BaseSearchPanel<Localidad> {

    public LocalidadSearchScreen(Class<Localidad> clazz) {
	super(clazz);
    }

    private static final long serialVersionUID = 4870452614299228051L;

    static final String[] VISIBLE_ITEM_PROPERTIES = new String[] { Localidad.Atributos.NOMBRE };
    static final String[] COLUMN_HEADERS = new String[] { Localidad.Atributos.NOMBRE };
    static final String[] VISIBLE_COLUMNS = new String[] { Localidad.Atributos.NOMBRE };

    @Override
    public void search() {
	Iterator<com.vaadin.ui.Component> it = filtersLayout.getComponentIterator();
	while (it.hasNext()) {
	    com.vaadin.ui.Field field = (Field) it.next();
	    @SuppressWarnings("unused")
	    Object o = field.getValue();
	}
    }

    @Override
    public void close() {
	// TODO Auto-generated method stub

    }

    @Override
    public void newEntity() {
	// TODO Auto-generated method stub

    }

    @Override
    public void clear() {
	// TODO Auto-generated method stub

    }

    @Override
    public BeanItemContainer<Localidad> getBeanItemContainer() {
	BeanItemContainer<Localidad> container = new BeanItemContainer<Localidad>(Localidad.class);
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
    protected String[] getVisibleItemProperties() {
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
    protected void initMapFieldGenerator() {
	addFieldGenerator(Localidad.Atributos.NOMBRE, new FieldGenerator() {

	    @Override
	    public Field createField() {
		return new TextField("Nombre");
	    }
	});

    }

}
