package com.tj.mmanager.base.persistence.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T, PK> {

	public T findById(PK id);
	
	public List<T> findAll();
	
	public void save(T entity);
	
	public Session getSession(); 
	
}
