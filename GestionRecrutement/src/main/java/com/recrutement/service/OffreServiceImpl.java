package com.recrutement.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.OffreRepository;
import com.recrutement.models.Offre;

@Service(value= "offreService")
public class OffreServiceImpl implements OffreService {
	
	@Autowired
	private OffreRepository offreRepository;

	@Override
	public Offre add(Offre offre) {
		offreRepository.save(offre)	;
    return offre;
	}

	@Override
	public List<Offre> getAll() {
		return offreRepository.findAll().stream()
				.sorted(Comparator.comparing(Offre::getDateAjout).reversed())
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Offre> getAllFiltred() {
		return offreRepository.findAll().stream()
				.sorted(Comparator.comparing(Offre::getDateAjout).reversed())              
				.filter(offre -> offre.getEtat().equals("disponible"))
				.collect(Collectors.toList());
	}

	@Override
	public Offre find(int id) {
		 return offreRepository.getOne(id);
	}

	@Override
	public Offre edit(Offre offre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
