package com.tj.mmanager.base.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:37 p.m.
 */
@Entity
public class TrabajoPractico extends ElementoEvaluable {

    public interface Atributos extends ElementoEvaluable.Atributos {
	static final String FECHA_ENTREGA = "fechaEntrega";
	static final String NUMERO = "numero";
    }

    private Date fechaEntrega;
    private Integer numero;

    public TrabajoPractico() {

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

    @Temporal(TemporalType.DATE)
    public Date getFechaEntrega() {
	return fechaEntrega;
    }

    public Integer getNumero() {
	return numero;
    }

    public void setFechaEntrega(Date fechaEntrega) {
	this.fechaEntrega = fechaEntrega;
    }

    public void setNumero(Integer numero) {
	this.numero = numero;
    }
}// end TrabajoPractico