package com.tj.mmanager.base.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
@Entity
public class Examen extends ElementoEvaluable {

	public interface Atributos extends ElementoEvaluable.Atributos {
		static final String TIPO = "tipo";
		static final String RECUPERATORIOS = "recuperatorios";
	}

	/**
	 * tipo = Oral, Escrito, Carpeta Abierta.
	 */
	private String tipo;
	private List<Recuperatorio> recuperatorios;

	public Examen() {

	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy=Recuperatorio.Atributos.EXAMEN)
	public List<Recuperatorio> getRecuperatorios() {
		return recuperatorios;
	}

	public void setRecuperatorios(List<Recuperatorio> recuperatorios) {
		this.recuperatorios = recuperatorios;
	}
}// end Examen