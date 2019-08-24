package com.recrutement.service;

import com.recrutement.models.ChoixDateEntretien;
import com.recrutement.models.Entretien;

public interface EntretienService {
	ChoixDateEntretien add(ChoixDateEntretien choixdate);
	ChoixDateEntretien get(int id);
	Entretien addEntretien(Entretien entretien);

}