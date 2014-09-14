package com.tj.mmanager.base.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:37 p.m.
 */
@Entity
public class HorarioMateria {

    public interface Atributos {
	static final String ID = "id", DIA = "dia", HORARIO = "horario", DIVISION = "division", MATERIA = "materia";
    }

    private Long id;
    private String dia;
    private Date horario;
    private Division division;
    private Materia materia;

    public HorarioMateria() {

    }

    @Override
    public void finalize() throws Throwable {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    public String getDia() {
	return dia;
    }

    @Temporal(TemporalType.TIME)
    public Date getHorario() {
	return horario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Division getDivision() {
	return division;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Materia getMateria() {
	return materia;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setDia(String dia) {
	this.dia = dia;
    }

    public void setHorario(Date horario) {
	this.horario = horario;
    }

    public void setDivision(Division division) {
	this.division = division;
    }

    public void setMateria(Materia materia) {
	this.materia = materia;
    }
}// end HorarioMateria