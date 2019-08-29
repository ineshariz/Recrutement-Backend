package com.recrutement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.ChoixDateRepository;
import com.recrutement.dao.ChoixdateRepo;
import com.recrutement.dao.EntretienRepository;
import com.recrutement.models.ChoixDateEntretien;
import com.recrutement.models.Choixdate;
import com.recrutement.models.Entretien;

@Service(value= "entretienService")

public class EntretienServiceImpl implements EntretienService {
	@Autowired
	private ChoixDateRepository choidateRepository;
	@Autowired

	private EntretienRepository entretienrepo;
	

	@Override
	public ChoixDateEntretien add(ChoixDateEntretien choixdate) {
		choidateRepository.save(choixdate);
		return choixdate;
	}
	@Override
	public ChoixDateEntretien get(int id) {
		return choidateRepository.findAll().stream().filter(x -> x.getDemande().getId()==id)
				.findFirst().get();

	}
	@Override
	public Entretien addEntretien(Entretien entretien) {
		entretienrepo.save(entretien);

		return entretien;
	}
	@Override
	public List<ChoixDateEntretien> getAll() {
		return choidateRepository.findAll();
	}
	@Override
	public List<Entretien> getAllEntretien() {
		return entretienrepo.findAll();
	}
	
	
	}

	
	

	


