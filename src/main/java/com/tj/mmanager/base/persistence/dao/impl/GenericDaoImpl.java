package com.tj.mmanager.base.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.mmanager.base.persistence.dao.GenericDao;
import com.tj.mmanager.base.persistence.filter.GenericFilter;

/**
 * Creditos por algo de ayuda en la parte generica de la implementacion.
 * {@linkplain http://wordgraphs.com/post/604/Generic-DAO-design-pattern-with-Java---Hibernate}
 * @author juan
 *
 * @param <T>
 *            La clase persistente
 * @param <PK>
 *            El tipo del identificador
 * 
 */
@Repository
public abstract class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

	@Autowired
	SessionFactory session;

	private Class<T> type;

	protected Class<T> getType() {
		return this.type;
	}

	protected String getClassName() {
		return type.getName();
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK id) {
		return (T) getSession().createCriteria(type).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) getSession().createCriteria(type).list();
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

	@Override
	public DetachedCriteria createCriteriaByFilter(GenericFilter<PK> filter) {
		DetachedCriteria criteria = DetachedCriteria.forClass(type);
		if (filter.getId() != null) {
			criteria.add(Restrictions.eq("id", filter.getId()));
		}
		return criteriaFilterHelper(filter, criteria);
	}
	
	@Override
	public abstract DetachedCriteria criteriaFilterHelper(GenericFilter<PK> filter, DetachedCriteria criteria);

	@SuppressWarnings("unchecked")
	@Override
	public List<T> filter(GenericFilter<PK> baseFilter) {
		DetachedCriteria criteria = createCriteriaByFilter(baseFilter);
		return criteria.getExecutableCriteria(getSession()).list();
	}

	// public abstract DetachedCriteria createFilterCriteria(T filter){
	//
	// }

}
