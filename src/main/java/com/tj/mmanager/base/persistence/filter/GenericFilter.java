package com.tj.mmanager.base.persistence.filter;

public class GenericFilter<PK> {
	
	private PK id;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
	
}
