package com.tj.mmanager.base.domain.model;

import java.util.List;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
public class Escuela {

    private Long id;
    private String direccion;
    private String email;
    private String nombre;
    private Integer numero;
    private Long telefono;
    private Localidad localidad;
    private List<CicloLectivo> ciclosLectivos;

    public Escuela(String direccion, String email, String nombre, Integer numero, Long telefono, Localidad localidad) {
	this.direccion = direccion;
	this.email = email;
	this.nombre = nombre;
	this.numero = numero;
	this.telefono = telefono;
	this.localidad = localidad;
    }

    public Escuela() {
    }

    @Override
    public void finalize() throws Throwable {

    }

    public Long getId() {
	return id;
    }

    public String getDireccion() {
	return direccion;
    }

    public String getEmail() {
	return email;
    }

    public String getNombre() {
	return nombre;
    }

    public Integer getNumero() {
	return numero;
    }

    public Long getTelefono() {
	return telefono;
    }

    public Localidad getLocalidad() {
	return localidad;
    }

    public List<CicloLectivo> getCiclosLectivos() {
	return ciclosLectivos;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setDireccion(String direccion) {
	this.direccion = direccion;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setNumero(Integer numero) {
	this.numero = numero;
    }

    public void setTelefono(Long telefono) {
	this.telefono = telefono;
    }

    public void setLocalidad(Localidad localidad) {
	this.localidad = localidad;
    }

    public void setCiclosLectivos(List<CicloLectivo> ciclosLectivos) {
	this.ciclosLectivos = ciclosLectivos;
    }
}// end Escuela