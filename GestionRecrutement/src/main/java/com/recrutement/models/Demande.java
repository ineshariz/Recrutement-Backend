package com.recrutement.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Candidat candidat;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offre_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Offre offre;
	
	/*
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choixdate_id")
    private ChoixDateEntretien choixDate;
	*/
	
	@Column
	private Date dateEntretien;
	
	@OneToOne(mappedBy = "demande")
    private ResultatQuiz resultatQuiz;
	
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

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	/*
	public ChoixDateEntretien getChoixDate() {
		return choixDate;
=======
	public Date getDateEntretien() {
		return dateEntretien;
>>>>>>> branch 'wolf' of https://github.com/ineshariz/Recrutement-Backend
	}

	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}
<<<<<<< HEAD
	*/

	public ResultatQuiz getResultatQuiz() {
		return resultatQuiz;
	}

	public void setResultatQuiz(ResultatQuiz resultatQuiz) {
		this.resultatQuiz = resultatQuiz;
	}

	
}
