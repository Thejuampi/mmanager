package com.tj.mmanager.base.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
@Entity
@Table(name = "ESCUELAS")
public class Escuela {

    public interface Atributos {
	static final String ID = "id";
	static final String DIRECCION = "direccion";
	static final String EMAIL = "email";
	static final String NOMBRE = "nombre";
	static final String NUMERO = "numero";
	static final String TELEFONO = "telefono";
	static final String LOCALIDAD = "localidad";
	static final String CICLOS_LECTIVOS = "ciclosLectivos";
    }

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

    @Id
    @GeneratedValue
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

    @ManyToOne(fetch = FetchType.LAZY)
    public Localidad getLocalidad() {
	return localidad;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = CicloLectivo.Atributos.ESCUELA)
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