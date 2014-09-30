package com.tj.mmanager.base.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Recuperatorio extends Examen {
	
	public interface Atributos extends Examen.Atributos {
		static final String EXAMEN = "examen";
	}
	
	private Examen examen;

	@ManyToOne(fetch=FetchType.LAZY)
	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	
		
}
