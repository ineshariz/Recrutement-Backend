package com.recrutement.service;

import java.util.List;

import com.recrutement.models.ChoixDateEntretien;
import com.recrutement.models.Entretien;
import com.recrutement.models.Offre;

public interface EntretienService {
	ChoixDateEntretien add(ChoixDateEntretien choixdate);
	ChoixDateEntretien get(int id);
	Entretien addEntretien(Entretien entretien);

}
