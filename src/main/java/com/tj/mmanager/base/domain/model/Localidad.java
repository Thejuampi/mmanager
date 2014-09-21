package com.tj.mmanager.base.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:37 p.m.
 */
@Entity
@Table(name = "LOCALIDADES")
public class Localidad implements Serializable {


	private static final long serialVersionUID = -326841381655110225L;

	public interface Atributos {
	static final String ID = "id";
	static final String NOMBRE = "nombre";
	static final String ESCUELAS = "escuelas";
    }

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

    @Id
    @GeneratedValue
    public Long getId() {
	return id;
    }

    public String getNombre() {
	return nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = Escuela.Atributos.LOCALIDAD)
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