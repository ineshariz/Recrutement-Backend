package com.recrutement.models;

import java.util.Date;

import javax.persistence.Column;

public class Recruteur {

	@Column
	private String departement;
	
	@Column
	private Date dateRecrutement;

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public Date getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	
	
}
