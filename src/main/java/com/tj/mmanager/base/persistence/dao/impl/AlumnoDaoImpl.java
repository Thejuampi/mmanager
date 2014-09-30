package com.tj.mmanager.base.persistence.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.tj.mmanager.base.domain.model.Alumno;
import com.tj.mmanager.base.persistence.dao.AlumnoDao;
import com.tj.mmanager.base.persistence.filter.AlumnoFilter;
import com.tj.mmanager.base.persistence.filter.GenericFilter;

@Repository
@Scope("singleton")
public class AlumnoDaoImpl extends GenericDaoImpl<Alumno, Long> implements
		AlumnoDao {

	private static final long serialVersionUID = 6798746101395056984L;
	
	@Override
	@Autowired
	public void setSession(SessionFactory session) {
		super.setSession(session);
	}

	@Override
	public DetachedCriteria criteriaFilterHelper(GenericFilter<Long> filter,
			DetachedCriteria criteria) {
		
		AlumnoFilter f = (AlumnoFilter) filter;
		
		if(StringUtils.isNotBlank(f.getApellido())){
			criteria.add(Restrictions.ilike(Alumno.Atributos.APELLIDO, f.getApellido(),MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(f.getNombre())) {
			criteria.add(Restrictions.ilike(Alumno.Atributos.NOMBRE, f.getNombre(), MatchMode.ANYWHERE));
		}
		
		if(f.getEscuela() != null) {
			criteria.add(Restrictions.eq(Alumno.Atributos.ESCUELA, f.getEscuela()));
		}
		
		if(f.getDivisionActual() != null) {
			criteria.add(Restrictions.eq(Alumno.Atributos.DIVISION_ACTUAL, f.getDivisionActual()));
		}
		return criteria;
	}

}
