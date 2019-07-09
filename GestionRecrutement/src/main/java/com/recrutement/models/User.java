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
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "User")
@Table(name = "User")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	
	@Column
	private String nomPrenom;
	
	@Column
	private String pass;
	
	@Column
	private String email;
	
	@Column
	private Date dateRecurtement;
	
	@Column
	private String cv;

	@Column
	private String numTel;
	
	@Column
	private String photo;
 
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
	
	public User() {

	}

	public User(int id, String nomPrenom, String pass, String email, Date dateRecurtement, String cv, 
			Role role, String photo) {
		super();
		this.id = id;
		this.nomPrenom = nomPrenom;
		this.pass = pass;
		this.email = email;
		this.dateRecurtement = dateRecurtement;
		this.cv = cv;
		this.role = role;
		this.photo = photo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateRecurtement() {
		return dateRecurtement;
	}

	public void setDateRecurtement(Date dateRecurtement) {
		this.dateRecurtement = dateRecurtement;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}	

	
}
