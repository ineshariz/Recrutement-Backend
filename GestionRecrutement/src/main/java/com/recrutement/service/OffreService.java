package com.recrutement.service;

import java.util.List;

import com.recrutement.models.Offre;

public interface OffreService {
	Offre add(Offre offre);
	List<Offre> getAll();
	Offre find(int id);
	Offre edit(Offre offre); 
	
}
