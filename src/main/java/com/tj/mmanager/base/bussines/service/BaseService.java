package com.tj.mmanager.base.bussines.service;

import java.util.List;

public interface BaseService<T,PK> {
	
	public T findById(PK id);
	
	public List<T> findAll();
	
	public void save(T entity);
	
}
