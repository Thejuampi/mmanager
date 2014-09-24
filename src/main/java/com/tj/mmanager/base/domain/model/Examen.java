package com.tj.mmanager.base.domain.model;

import javax.persistence.Entity;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
@Entity
public class Examen extends ElementoEvaluable {

    public interface Atributos extends ElementoEvaluable.Atributos {
	static final String TIPO = "tipo";
    }

    /**
     * tipo = Oral, Escrito, Carpeta Abierta.
     */
    private String tipo;

    public Examen() {

    }

    @Override
    public void finalize() throws Throwable {
	super.finalize();
    }

//    @Override
//    @Id
//    //@GeneratedValue
//    public Long getId() {
//	return super.getId();
//    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }
}// end Examen