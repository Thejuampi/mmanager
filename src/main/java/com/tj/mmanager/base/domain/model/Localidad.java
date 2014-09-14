package com.tj.mmanager.base.domain.model;

import java.util.List;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:37 p.m.
 */
public class Localidad {

    private Long id;
    private String nombre;
    private List<Escuela> escuelas;

    public Localidad() {

    }

    public Localidad(String nombre) {
	this.nombre = nombre;
    }

    @Override
    public void finalize() throws Throwable {

    }

    public Long getId() {
	return id;
    }

    public String getNombre() {
	return nombre;
    }

    public List<Escuela> getEscuelas() {
	return escuelas;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setEscuelas(List<Escuela> escuelas) {
	this.escuelas = escuelas;
    }
}// end Localidad