package com.tj.mmanager.base.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tema {
	public interface Atributos{
		public static final String NOMBRE = "nombre";
		public static final String MATERIA = "materia";
		public static final String ELEMENTO_EVALUABLE = "elementoEvaluable";
	}
	
	private String nombre;
	private Materia materia;
	private ElementoEvaluable elementoEvaluable;
	
	@Column(nullable = false, length=255)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany(fetch=FetchType.LAZY, mappedBy=ElementoEvaluable.Atributos.TEMAS)
	public ElementoEvaluable getElementoEvaluable() {
		return elementoEvaluable;
	}

	public void setElementoEvaluable(ElementoEvaluable elementoEvaluable) {
		this.elementoEvaluable = elementoEvaluable;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
