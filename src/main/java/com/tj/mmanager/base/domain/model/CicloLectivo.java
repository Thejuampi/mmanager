package com.tj.mmanager.base.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
@Entity
public class CicloLectivo {

    public interface Atributos {
	static final String ID = "id";
	static final String ANIO = "anio";
	static final String FECHA_FIN = "fechaFin";
	static final String FECHA_INICIO = "fechaInicio";
	static final String ESCUELAS = "escuelas";
	static final String TRIMESTRES = "trimestres";
    }

    private Long id;
    private Short anio;
    private Date fechaFin;
    private Date fechaInicio;
    private List <Escuela> escuelas;
    private List<Trimestre> trimestres;

    public CicloLectivo() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    public Short getAnio() {
	return anio;
    }

    @Temporal(TemporalType.DATE)
    public Date getFechaFin() {
	return fechaFin;
    }

    @Temporal(TemporalType.DATE)
    public Date getFechaInicio() {
	return fechaInicio;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy=Escuela.Atributos.CICLOS_LECTIVOS)
    public List<Escuela> getEscuelas() {
	return escuelas;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy=Trimestre.Atributos.CICLO_LECTIVO)
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

    public void setEscuelas(List<Escuela> escuelas) {
	this.escuelas = escuelas;
    }

    public void setTrimestres(List<Trimestre> trimestres) {
	this.trimestres = trimestres;
    }
}// end CicloLectivo