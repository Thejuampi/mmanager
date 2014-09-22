package com.tj.mmanager.base.bussines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tj.mmanager.base.bussines.service.BaseService;
import com.tj.mmanager.base.persistence.dao.BaseDao;

public class BaseServiceImpl<T,PK> implements BaseService<T, PK> {
	
	@Autowired
	BaseDao<T, PK> dao;

	@Override
	public T findById(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(T entity) {
		dao.save(entity);
	}

}
