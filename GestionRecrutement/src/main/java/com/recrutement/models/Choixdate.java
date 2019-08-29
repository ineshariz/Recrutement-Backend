package com.recrutement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "choixdate")

public class Choixdate {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	
	@Column
	private String date1;
	
	@Column
	private String date2;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande_id")
    private Demande demande;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	

	
}
