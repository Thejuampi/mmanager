package com.tj.mmanager.base.view.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.bussines.service.LocalidadService;
import com.tj.mmanager.base.domain.model.Localidad;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComponentContainer;

@Component
@Scope("prototype")
public class LocalidadSearchScreen extends BaseSearchPanel<Localidad> {

    private static final long serialVersionUID = 4870452614299228051L;

    static final String[] VISIBLE_ITEM_PROPERTIES = new String[] { Localidad.Atributos.NOMBRE };
    static final String[] COLUMN_HEADERS = new String[] { Localidad.Atributos.NOMBRE };
    static final String[] VISIBLE_COLUMNS = new String[] { Localidad.Atributos.NOMBRE };
    
    @Autowired
    LocalidadService service;

    @Override
    public void search(Localidad bean) {
    	List<Localidad> localidades = service.findAll();
    	reloadResultsTable(localidades, true);
    }

    @Override
    public void close() {
    	if(getParent() != null){
    		ComponentContainer container = (ComponentContainer)getParent();
        	container.removeComponent(this);	
    	} 
    }

    @Override
    public void newEntity(Localidad bean) {

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
    protected Localidad getBean() {
	return new Localidad();
    }


//    @Override
//    protected void initMapFieldGenerator() {
//	addFieldGenerator(Localidad.Atributos.NOMBRE, new FieldGenerator() {
//
//	    @Override
//	    public Field createField() {
//		return new TextField("Nombre");
//	    }
//	});
//
//    }

}
