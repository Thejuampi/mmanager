package com.tj.mmanager.base.bussines.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tj.mmanager.base.bussines.service.EscuelaService;
import com.tj.mmanager.base.domain.model.Escuela;
import com.tj.mmanager.base.persistence.dao.GenericDao;

@Service
@Scope("singleton")
public class EscuelaServiceImpl extends BaseServiceImpl<Escuela, Long> implements EscuelaService {

	private static final long serialVersionUID = 1L;
	
	@Override
	@Autowired
	protected void setDao(@Qualifier("escuelaDaoImpl")GenericDao<Escuela, Long> dao) {
		super.setDao(dao);
	}
}
