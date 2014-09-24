package com.tj.mmanager.base.persistence.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.tj.mmanager.base.domain.model.Localidad;
import com.tj.mmanager.base.persistence.dao.LocalidadDao;
import com.tj.mmanager.base.persistence.filter.GenericFilter;
import com.tj.mmanager.base.persistence.filter.LocalidadFilter;

@Repository
@Scope("singleton")
public class LocalidadDaoImpl extends GenericDaoImpl<Localidad, Long> implements
		LocalidadDao {
	
	private static final long serialVersionUID = 6169411316525682736L;

	@Override
	@Autowired
	public void setSession(SessionFactory session) {
		super.setSession(session);
	}
	
	@Override
	public DetachedCriteria criteriaFilterHelper(GenericFilter<Long> filter,
			DetachedCriteria criteria) {
		
		LocalidadFilter f = (LocalidadFilter) filter;
		
		if(StringUtils.isNotBlank(f.getNombre())){
			criteria.add(Restrictions.ilike( Localidad.Atributos.NOMBRE, f.getNombre() ));
		}
			
		return criteria;
	}
	
}
