package com.tj.mmanager.base.bussines.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tj.mmanager.base.bussines.service.AlumnoService;
import com.tj.mmanager.base.domain.model.Alumno;
import com.tj.mmanager.base.persistence.dao.GenericDao;

@Service
@Scope("singleton")
public class AlumnoServiceImpl extends BaseServiceImpl<Alumno, Long> implements AlumnoService{

	private static final long serialVersionUID = 3786354316039419765L;

	@Override
	@Autowired
	protected void setDao(@Qualifier("alumnoDaoImpl")GenericDao<Alumno, Long> dao) {
		super.setDao(dao);
	}
}
