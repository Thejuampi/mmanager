package com.tj.mmanager.base.bussines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tj.mmanager.base.bussines.service.LocalidadService;
import com.tj.mmanager.base.domain.model.Localidad;
import com.tj.mmanager.base.persistence.dao.GenericDao;

@Service
@Scope("singleton")
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long>
		implements LocalidadService {
	
	private static final long serialVersionUID = -7799141139109962063L;

	@Autowired
	@Override
	protected void setDao(@Qualifier("localidadDaoImpl")GenericDao<Localidad, Long> dao) {
		super.setDao(dao);
	}
	
	@Override
	public List<Localidad> findAll() {
		List<Localidad> localidades = dao.findAll();
		return localidades;
	}

}
