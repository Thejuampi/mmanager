package com.tj.mmanager.base.persistence.filter;

import com.tj.mmanager.base.domain.model.Division;
import com.tj.mmanager.base.domain.model.Escuela;

public class AlumnoFilter extends GenericFilter<Long> {
    private String apellido;
    private String nombre;
    private Division divisionActual;
    private Escuela escuela;
    
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Division getDivisionActual() {
		return divisionActual;
	}
	public void setDivisionActual(Division divisionActual) {
		this.divisionActual = divisionActual;
	}
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
}
