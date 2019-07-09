package com.recrutement.models;

import java.util.Date;

import javax.persistence.Column;

public class Candidat {

	@Column
	private String cv;
	
	@Column 
	private Date dateInscription;

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	
	
}
