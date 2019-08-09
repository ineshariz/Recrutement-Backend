package com.recrutement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.ReponseRepository;
import com.recrutement.models.Reponse;


@Service(value= "reponseService")
public class ReponseServiceImp implements ReponseService {

	@Autowired
	ReponseRepository reponseRepository;
	
	@Override
	public Reponse commit(Reponse reponse) {
		reponseRepository.save(reponse);
		return reponse;
	}

	@Override
	public void changeStatus(Reponse reponse,boolean status) {
		reponse.setActive(status);
		reponseRepository.save(reponse);
	}

	@Override
	public List<Reponse> getAll() {
		return reponseRepository.findAll();
	}

	@Override
	public Optional<Reponse> find(int id) {
		return reponseRepository.findById(id);
	}

	@Override
	public List<Reponse> getAllActivated() {
		return reponseRepository.findAll().stream()               
				.filter(reponse -> reponse.isActive()==true)   
				.collect(Collectors.toList());
	}
	
	
	
	

	
}
