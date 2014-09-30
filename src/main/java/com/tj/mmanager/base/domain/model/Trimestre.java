package com.tj.mmanager.base.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	static final String CICLO_LECTIVO = "cicloLectivo";
	static final String CURSOS = "cursos";
	static final String ELEMENTOS_EVALUABLES = "elementosEvaluables";
    }

    private Long id;
    private Date fechaFin;
    private Date fechaInicio;
    private String nombre;
    private CicloLectivo cicloLectivo;
    private List<Curso> cursos;
    private List<ElementoEvaluable> elementosEvaluables;

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
    
    @ManyToOne(fetch=FetchType.LAZY)
	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = ElementoEvaluable.Atributos.TRIMESTRE)
	public List<ElementoEvaluable> getElementosEvaluables() {
		return elementosEvaluables;
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

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	@ManyToMany(fetch=FetchType.LAZY, mappedBy = Curso.Atributos.TRIMESTRES)
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void setElementosEvaluables(List<ElementoEvaluable> elementosEvaluables) {
		this.elementosEvaluables = elementosEvaluables;
	}
}// end Trimestre