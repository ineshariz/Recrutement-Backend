package com.recrutement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.OffreRepository;

@Service(value= "offreService")
public class OffreServiceImpl implements OffreService {
	
	@Autowired
	private OffreRepository offreRepository;
	
	
}
