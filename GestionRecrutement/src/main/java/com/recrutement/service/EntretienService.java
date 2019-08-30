package com.recrutement.service;

import java.util.List;
import com.recrutement.models.ChoixDateEntretien;
import com.recrutement.models.Choixdate;
import com.recrutement.models.Entretien;

public interface EntretienService {
	ChoixDateEntretien add(ChoixDateEntretien choixdate);
	ChoixDateEntretien get(int id);
	Entretien addEntretien(Entretien entretien);
	List<ChoixDateEntretien> getAll();
	List<Entretien> getAllEntretien();


}