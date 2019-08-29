package com.recrutement.service;

import java.util.List;
import java.util.Optional;

import com.recrutement.models.Candidat;
import com.recrutement.models.Offre;
import com.recrutement.models.User;

public interface UserService {
	
	User addUser(User user);
	
	List<User> getListUser();

	void deleteUser(Integer id);

	 Candidat findById(Integer id);
	 User findUserById(Integer id);

	 Optional<User> findByEmail(String nomPrenom);
	 List<Number>nombreCandidat(Offre offre);
	 Candidat edit(Candidat ca);
		List<Candidat> getListCandidat();

}