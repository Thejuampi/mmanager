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

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */

@Entity
public class Division {

    public interface Atributos {
	static final String ID = "id", NOMBRE = "nombre", CURSO = "curso", ALUMNOS = "alumnos", HORARIOS_MATERIAS = "horariosMaterias", ELEMENTOS_EVALUABLES = "elementosEvaluables";
    }

    private Long id;
    private String nombre;
    private Curso curso;
    private List<Alumno> alumnos;
    private List<HorarioMateria> horariosMaterias;
    private List<ElementoEvaluable> elementosEvaluables;

    public Division() {

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

    @ManyToOne(fetch = FetchType.LAZY)
    public Curso getCurso() {
	return curso;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Alumno> getAlumnos() {
	return alumnos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = HorarioMateria.Atributos.DIVISION)
    public List<HorarioMateria> getHorariosMaterias() {
	return horariosMaterias;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    public List<ElementoEvaluable> getElementosEvaluables() {
	return elementosEvaluables;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setCurso(Curso curso) {
	this.curso = curso;
    }

    public void setAlumnos(List<Alumno> alumnos) {
	this.alumnos = alumnos;
    }

    public void setHorariosMaterias(List<HorarioMateria> horariosMaterias) {
	this.horariosMaterias = horariosMaterias;
    }

    public void setElementosEvaluables(List<ElementoEvaluable> elementosEvaluables) {
	this.elementosEvaluables = elementosEvaluables;
    }
}// end Division