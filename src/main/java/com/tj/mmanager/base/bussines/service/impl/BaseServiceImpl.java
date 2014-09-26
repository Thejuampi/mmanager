package com.tj.mmanager.base.bussines.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tj.mmanager.base.bussines.service.BaseService;
import com.tj.mmanager.base.persistence.dao.GenericDao;
import com.tj.mmanager.base.persistence.filter.GenericFilter;

public abstract class BaseServiceImpl<T,PK> implements BaseService<T, PK> {
	
	private static final long serialVersionUID = -5552728755340866344L;

	protected GenericDao<T, PK> dao;

	protected void setDao(GenericDao<T,PK> dao){
		this.dao = dao;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public T findById(PK id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveEntity(T entity) {
		dao.saveEntity(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<T> filter(GenericFilter<PK> baseFilter) {
		return dao.filter(baseFilter);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void updateEntity(T entity) {
		dao.updateEntity(entity);
	}

}
