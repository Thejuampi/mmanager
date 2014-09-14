package com.tj.mmanager.base.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    }

    // private List<ElementoEvaluable> elementosEvaluables;
    private List<DetalleElementoEvaluable> detallesElementosEvaluables;
    private List<Division> divisiones;

    public Alumno() {

    }

    @Override
    public void finalize() throws Throwable {
	super.finalize();
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return super.getId();
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = DetalleElementoEvaluable.Atributos.ALUMNO)
    public List<DetalleElementoEvaluable> getDetallesElementosEvaluables() {
	return detallesElementosEvaluables;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = Alumno.Atributos.DIVISIONES)
    public List<Division> getDivisiones() {
	return divisiones;
    }

    public void setDetallesElementosEvaluables(List<DetalleElementoEvaluable> detallesElementosEvaluables) {
	this.detallesElementosEvaluables = detallesElementosEvaluables;
    }

    public void setDivisiones(List<Division> divisiones) {
	this.divisiones = divisiones;
    }
}// end Alumno