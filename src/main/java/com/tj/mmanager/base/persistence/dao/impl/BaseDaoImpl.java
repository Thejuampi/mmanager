package com.tj.mmanager.base.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tj.mmanager.base.domain.model.Localidad;
import com.tj.mmanager.base.persistence.dao.BaseDao;

@Repository
public class BaseDaoImpl<T, PK> implements BaseDao<T, PK> {
	
	@Autowired
	SessionFactory session;
	
	T generico;

	@Override
	public T findById(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<T> findAll() {
		List<T> retorno  = getSession().createCriteria(Localidad.class).list();
		return retorno;
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
		getSession().flush();
	}

	@Override
	public Session getSession() {
		return session.getCurrentSession();
	}
	
//	public abstract DetachedCriteria createFilterCriteria(T filter){
//		
//	}

}
