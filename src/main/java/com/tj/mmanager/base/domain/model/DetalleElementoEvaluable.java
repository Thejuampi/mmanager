package com.tj.mmanager.base.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
@Entity
public class DetalleElementoEvaluable {

    public interface Atributos {
	static final String ID = "id";
	static final String COMENTARIOS = "comentarios";
	static final String CONCEPTO = "concepto";
	static final String NOTA = "nota";
	static final String ALUMNO = "alumno";
	static final String ELEMENTO_EVALUABLE = "elementoEvaluable";
    }

    private Long id;
    private String comentarios = "";
    private String concepto = "";
    private float nota = 0.0f;
    private Alumno alumno;
    private ElementoEvaluable elementoEvaluable;

    public DetalleElementoEvaluable() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    public String getComentarios() {
	return comentarios;
    }

    public String getConcepto() {
	return concepto;
    }

    public float getNota() {
	return nota;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Alumno getAlumno() {
	return alumno;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public ElementoEvaluable getElementoEvaluable() {
	return elementoEvaluable;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setComentarios(String comentarios) {
	this.comentarios = comentarios;
    }

    public void setConcepto(String concepto) {
	this.concepto = concepto;
    }

    public void setNota(float nota) {
	this.nota = nota;
    }

    public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
    }

    public void setElementoEvaluable(ElementoEvaluable elementoEvaluable) {
	this.elementoEvaluable = elementoEvaluable;
    }
}// end DetalleElementoEvaluable