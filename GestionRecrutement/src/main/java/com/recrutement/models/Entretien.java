package com.recrutement.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Entretien {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	
	@Column
	private Date date;
	
	@Column
	private String type;
	
	@Column
	private String etat;
	
	@Column
	private int phase;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private User candidat;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "entretien_recruteurs",joinColumns = { @JoinColumn(name = "recruteur_id") }, inverseJoinColumns = { @JoinColumn(name = "entretien_id") })
	private List<User> recruteurs= new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public User getCandidat() {
		return candidat;
	}

	public void setCandidat(User candidat) {
		this.candidat = candidat;
	}

	public List<User> getRecruteurs() {
		return recruteurs;
	}

	public void setRecruteurs(List<User> recruteurs) {
		this.recruteurs = recruteurs;
	}
	
	
}
