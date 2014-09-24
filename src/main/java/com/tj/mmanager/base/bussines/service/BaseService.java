package com.tj.mmanager.base.bussines.service;

import java.util.List;

import com.tj.mmanager.base.persistence.filter.GenericFilter;

public interface BaseService<T,PK> {
	
	public List<T> filter(GenericFilter<PK> baseFilter);
	
	public T findById(PK id);
	
	public List<T> findAll();
	
	public void save(T entity);
	
}
