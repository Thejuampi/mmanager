package com.tj.mmanager.base.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
@Entity
public class Alumno extends Persona {

    public interface Atributos extends Persona.Atributos {
	static final String DETALLES_ELEMENTOS_EVALUABLES = "detallesElementosEvaluables", DIVISIONES = "divisiones";
    static final String ESCUELA = "escuela";
    }

    private Escuela escuela;
    
    // private List<ElementoEvaluable> elementosEvaluables;
    private List<DetalleElementoEvaluable> detallesElementosEvaluables;
    private List<Division> divisiones;
    private Division divisionActual;

    public Alumno() {

    }

    @Override
    public void finalize() throws Throwable {
	super.finalize();
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = DetalleElementoEvaluable.Atributos.ALUMNO)
    public List<DetalleElementoEvaluable> getDetallesElementosEvaluables() {
	return detallesElementosEvaluables;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = Division.Atributos.ALUMNOS)
    public List<Division> getDivisiones() {
	return divisiones;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
	public Escuela getEscuela() {
		return escuela;
	}
    
    @ManyToOne(fetch=FetchType.LAZY)
	public Division getDivisionActual() {
		return divisionActual;
	}

    public void setDetallesElementosEvaluables(List<DetalleElementoEvaluable> detallesElementosEvaluables) {
	this.detallesElementosEvaluables = detallesElementosEvaluables;
    }

    public void setDivisiones(List<Division> divisiones) {
	this.divisiones = divisiones;
    }

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public void setDivisionActual(Division divisionActual) {
		this.divisionActual = divisionActual;
	}
}// end Alumno