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
public class Trimestre {

    public interface Atributos {
	static final String ID = "id";
	static final String NOMBRE = "nombre";
	static final String FECHA_INICIO = "fechaInicio";
	static final String FECHA_FIN = "fechaFin";
    }

    private Long id;
    private Date fechaFin;
    private Date fechaInicio;
    private String nombre;

    public Trimestre() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue
    public Long getId() {
	return id;
    }

    @Temporal(TemporalType.DATE)
    public Date getFechaFin() {
	return fechaFin;
    }

    @Temporal(TemporalType.DATE)
    public Date getFechaInicio() {
	return fechaInicio;
    }

    public String getNombre() {
	return nombre;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setFechaFin(Date fechaFin) {
	this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
}// end Trimestre