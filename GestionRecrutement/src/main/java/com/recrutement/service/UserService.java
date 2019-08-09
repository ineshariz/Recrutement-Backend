package com.recrutement.service;

import java.util.List;
import java.util.Optional;

import com.recrutement.models.Candidat;
import com.recrutement.models.Recruteur;
import com.recrutement.models.User;

public interface UserService {
	
	User addUser(User user);
	
	Recruteur addRecruteur (Recruteur recruteur);
	
	Candidat addCandidat (Candidat candidat);
	
	Recruteur editRecruteur (Recruteur recruteur);
	
	List<Recruteur> getListRecruteur();
	
	List<User> getListUser();

	void deleteUser(Integer id);

	 User findById(Integer id);
	 	 
	 Optional<User> findByEmail(String nomPrenom);
	 
}