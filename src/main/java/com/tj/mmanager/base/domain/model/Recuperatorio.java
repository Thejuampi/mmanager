package com.tj.mmanager.base.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Recuperatorio extends Examen {
	
	public interface Atributos extends Examen.Atributos {
		static final String EXAMEN = "examen";
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Examen examen;
		
}
