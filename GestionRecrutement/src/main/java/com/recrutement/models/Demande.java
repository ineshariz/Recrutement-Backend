package com.recrutement.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Demande {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	
	@Column
	private Date datePostulation;
	
	@Column
	private String lettreMotivation;
	
	@Column
	private String etat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatePostulation() {
		return datePostulation;
	}

	public void setDatePostulation(Date datePostulation) {
		this.datePostulation = datePostulation;
	}

	public String getLettreMotivation() {
		return lettreMotivation;
	}

	public void setLettreMotivation(String lettreMotivation) {
		this.lettreMotivation = lettreMotivation;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
