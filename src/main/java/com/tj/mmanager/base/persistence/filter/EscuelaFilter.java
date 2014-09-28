package com.tj.mmanager.base.persistence.filter;

import com.tj.mmanager.base.domain.model.Localidad;

public class EscuelaFilter extends GenericFilter<Long> {
    
    private String email;
    private String nombre;
    private Integer numero;
    private Localidad localidad;
	
	public String getEmail() {
		return email;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getNumero() {
		return numero;
	}
	
	public Localidad getLocalidad() {
		return localidad;
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
	
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}
