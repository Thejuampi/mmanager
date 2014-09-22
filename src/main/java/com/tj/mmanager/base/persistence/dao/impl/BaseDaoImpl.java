package com.tj.mmanager.base.persistence.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tj.mmanager.base.persistence.dao.BaseDao;

public class BaseDaoImpl<T, PK> implements BaseDao<T, PK> {
	
	@Autowired
	SessionFactory session;

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

}
