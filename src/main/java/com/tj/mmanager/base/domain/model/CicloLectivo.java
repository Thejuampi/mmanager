package com.tj.mmanager.base.domain.model;

import java.util.Date;



/**
 * @author Thejuampi
 * @version 1.0
 * @created 13-Sep-2014 07:54:36 p.m.
 */
public class CicloLectivo {

	private Short anio;
	private Date fechaFin;
	private Date fechaInicio;
	private Long id;
	private Escuela escuela;
	private Trimestre trimestre;

	public CicloLectivo(){

	}

	public void finalize() throws Throwable {

	}
}//end CicloLectivo