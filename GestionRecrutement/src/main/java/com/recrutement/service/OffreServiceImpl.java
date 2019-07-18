package com.recrutement.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offre> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offre find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offre edit(Offre offre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
