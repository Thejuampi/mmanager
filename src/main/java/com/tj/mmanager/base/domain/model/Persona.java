package com.tj.mmanager.base.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:37 p.m.
 */
@Entity
@Table(name = "PERSONAS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona {

    public interface Atributos {
	static final String ID = "id", APELLIDO = "apellido", NOMBRE = "nombre";
    }

    private Long id;
    private String apellido;
    private String nombre;

    public Persona() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    public String getApellido() {
	return apellido;
    }

    public String getNombre() {
	return nombre;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
}// end Persona