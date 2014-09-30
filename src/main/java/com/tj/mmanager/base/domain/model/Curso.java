package com.tj.mmanager.base.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
@Entity
@Table(name = "CURSOS")
public class Curso {

    public interface Atributos {
	static final String ID = "id";
	static final String NOMBRE = "nombre";
	static final String TRIMESTRES = "trimestres";
	static final String DIVISIONES = "divisiones";
	static final String MATERIAS = "materias";
	static final String ESCUELA = "escuela";
    }

    private Long id;
    private String nombre;
    private List<Trimestre> trimestres;
    private List<Division> divisiones;
    private List<Materia> materias;
    private Escuela escuela;

    public Curso() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    public String getNombre() {
	return nombre;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    public List<Trimestre> getTrimestres() {
	return trimestres;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy = Division.Atributos.CURSO)
    public List<Division> getDivisiones() {
	return divisiones;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    public List<Materia> getMaterias() {
	return materias;
	//TODO ver quien mapea a quien.
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
	public Escuela getEscuela() {
		return escuela;
	}

    public void setId(Long id) {
	this.id = id;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setTrimestres(List<Trimestre> trimestres) {
	this.trimestres = trimestres;
    }

    public void setDivisiones(List<Division> divisiones) {
	this.divisiones = divisiones;
    }

    public void setMaterias(List<Materia> materias) {
	this.materias = materias;
    }

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
}// end Curso