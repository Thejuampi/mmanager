package com.tj.mmanager.base.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */

@Entity
@Table(name = "ELEMENTOS_EVALUABLES")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElementoEvaluable {

    public interface Atributos {
	static final String ID = "id";
	static final String FECHA_CREACION = "fechaCreacion";
	static final String NOMBRE = "nombre";
	static final String PESO = "peso";
	static final String DIVISIONES = "divisiones";
	static final String MATERIA = "materia";
	static final String DETALLES = "detalles";
    }

    private Long id;
    private Date fechaCreacion;
    private String nombre;
    private Float peso;
    private List<Division> divisiones;
    private Materia materia;
    private List<DetalleElementoEvaluable> detalles;

    public ElementoEvaluable() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    @Temporal(TemporalType.DATE)
    public Date getFechaCreacion() {
	return fechaCreacion;
    }

    public String getNombre() {
	return nombre;
    }

    public Float getPeso() {
	return peso;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = Division.Atributos.ELEMENTOS_EVALUABLES)
    public List<Division> getDivisiones() {
	return divisiones;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Materia getMateria() {
	return materia;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<DetalleElementoEvaluable> getDetalles() {
	return detalles;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setFechaCreacion(Date fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setPeso(Float peso) {
	this.peso = peso;
    }

    public void setDivisiones(List<Division> divisiones) {
	this.divisiones = divisiones;
    }

    public void setMateria(Materia materia) {
	this.materia = materia;
    }

    public void setDetalles(List<DetalleElementoEvaluable> detalles) {
	this.detalles = detalles;
    }
}// end ElementoEvaluable