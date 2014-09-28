package com.tj.mmanager.base.persistence.filter;

public class LocalidadFilter extends GenericFilter<Long> {
	 
	private String nombre;
	
	public LocalidadFilter(String nombre){
		this.nombre = nombre;
	}
	
	public LocalidadFilter() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 
}
