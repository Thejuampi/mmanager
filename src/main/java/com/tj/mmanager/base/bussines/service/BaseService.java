package com.tj.mmanager.base.bussines.service;

import java.io.Serializable;
import java.util.List;

import com.tj.mmanager.base.persistence.filter.GenericFilter;

public interface BaseService<T,PK> extends Serializable {
	
	public List<T> filter(GenericFilter<PK> baseFilter);
	
	public T findById(PK id);
	
	public List<T> findAll();
	
	public void saveEntity(T entity);
	
	public void updateEntity(T entity);
	
}
