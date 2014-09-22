package com.tj.mmanager.base.bussines.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tj.mmanager.base.bussines.service.LocalidadService;
import com.tj.mmanager.base.domain.model.Localidad;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long>
		implements LocalidadService {
	
	@Override
	public List<Localidad> findAll() {
		List<Localidad> localidades = dao.findAll();
		return localidades;
	}

}
