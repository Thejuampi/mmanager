package com.tj.mmanager.base.persistence.dao;

import java.util.List;

public interface BaseDao<T, PK> {

	public T findById(PK id);
	
	public List<T> findAll();
	
}
