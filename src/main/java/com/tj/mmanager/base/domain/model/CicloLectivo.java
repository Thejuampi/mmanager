package com.tj.mmanager.base.domain.model;

import java.util.Date;
import java.util.List;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
public class CicloLectivo {

    private Long id;
    private Short anio;
    private Date fechaFin;
    private Date fechaInicio;
    private Escuela escuela;
    private List<Trimestre> trimestres;

    public CicloLectivo() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    public Long getId() {
	return id;
    }

    public Short getAnio() {
	return anio;
    }

    public Date getFechaFin() {
	return fechaFin;
    }

    public Date getFechaInicio() {
	return fechaInicio;
    }

    public Escuela getEscuela() {
	return escuela;
    }

    public List<Trimestre> getTrimestres() {
	return trimestres;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setAnio(Short anio) {
	this.anio = anio;
    }

    public void setFechaFin(Date fechaFin) {
	this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
    }

    public void setEscuela(Escuela escuela) {
	this.escuela = escuela;
    }

    public void setTrimestres(List<Trimestre> trimestres) {
	this.trimestres = trimestres;
    }
}// end CicloLectivo