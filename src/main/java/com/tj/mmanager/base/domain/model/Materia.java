package com.tj.mmanager.base.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:37 p.m.
 */

@Entity
public class Materia {

    public interface Atributos {
	static final String ID = "id";
	static final String NOMBRE = "nombre";
	static final String ELEMENTOS_EVALUABLES = "elementosEvaluables";
	static final String HORARIOS_MATERIAS = "horariosMaterias";
	static final String TEMAS = "temas";
    }

    private Long id;
    private String nombre;
    private List<ElementoEvaluable> elementosEvaluables;
    // private List<Division> divisiones;
    private List<HorarioMateria> horariosMaterias;
    private List<Tema> temas;

    public Materia() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue
    public Long getId() {
	return id;
    }

    public String getNombre() {
	return nombre;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<ElementoEvaluable> getElementosEvaluables() {
	return elementosEvaluables;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<HorarioMateria> getHorariosMaterias() {
	return horariosMaterias;
    }
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy=Tema.Atributos.MATERIA)
	public List<Tema> getTemas() {
		return temas;
	}

    public void setId(Long id) {
	this.id = id;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setElementosEvaluables(List<ElementoEvaluable> elementosEvaluables) {
	this.elementosEvaluables = elementosEvaluables;
    }

    public void setHorariosMaterias(List<HorarioMateria> horariosMaterias) {
	this.horariosMaterias = horariosMaterias;
    }

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
}// end Materia