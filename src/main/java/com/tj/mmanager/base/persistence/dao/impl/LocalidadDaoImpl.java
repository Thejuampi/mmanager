package com.tj.mmanager.base.persistence.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.tj.mmanager.base.domain.model.Localidad;
import com.tj.mmanager.base.persistence.dao.LocalidadDao;
import com.tj.mmanager.base.persistence.filter.GenericFilter;
import com.tj.mmanager.base.persistence.filter.LocalidadFilter;

public class LocalidadDaoImpl extends GenericDaoImpl<Localidad, Long> implements
		LocalidadDao {

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
