package com.tj.mmanager.base.persistence.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.tj.mmanager.base.domain.model.Escuela;
import com.tj.mmanager.base.persistence.dao.EscuelaDao;
import com.tj.mmanager.base.persistence.filter.EscuelaFilter;
import com.tj.mmanager.base.persistence.filter.GenericFilter;

@Repository
@Scope("singleton")
public class EscuelaDaoImpl extends GenericDaoImpl<Escuela, Long> implements
		EscuelaDao {

	private static final long serialVersionUID = 1L;
	
	@Override
	@Autowired
	public void setSession(SessionFactory session) {
		super.setSession(session);
	}

	@Override
	public DetachedCriteria criteriaFilterHelper(GenericFilter<Long> filter,
			DetachedCriteria criteria) {
		EscuelaFilter f = (EscuelaFilter) filter;
		
		if( StringUtils.isNotBlank(f.getNombre()) ) {
			criteria.add(Restrictions.ilike(Escuela.Atributos.NOMBRE, f.getNombre(), MatchMode.ANYWHERE));
		}
		
		if (StringUtils.isNotBlank(f.getEmail())) {
			criteria.add(Restrictions.ilike(Escuela.Atributos.EMAIL, f.getEmail(), MatchMode.ANYWHERE));
		}
		
		if(f.getNumero() != null) {
			criteria.add(Restrictions.eq(Escuela.Atributos.NUMERO, f.getNumero()));
		}
		
		if(f.getLocalidad() != null) {
			criteria.add(Restrictions.eq(Escuela.Atributos.LOCALIDAD, f.getLocalidad()));
		}
		
		return criteria;
	}

}
