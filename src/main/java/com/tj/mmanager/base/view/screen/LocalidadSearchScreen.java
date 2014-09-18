package com.tj.mmanager.base.view.screen;

import org.springframework.stereotype.Component;

import com.tj.mmanager.base.domain.model.Localidad;
import com.vaadin.data.util.BeanItemContainer;

@Component
public class LocalidadSearchScreen extends BaseSearchPanel<Localidad> {

    private static final long serialVersionUID = 4870452614299228051L;

    @Override
    public void search() {
	// TODO Auto-generated method stub

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

}
