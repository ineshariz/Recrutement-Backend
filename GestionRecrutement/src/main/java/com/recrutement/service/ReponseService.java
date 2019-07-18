package com.recrutement.service;

import java.util.List;
import java.util.Optional;
import com.recrutement.models.Reponse;

public interface ReponseService {
	Reponse commit(Reponse reponse);
	void changeStatus(Reponse reponse, boolean status);
	List<Reponse> getAll();
	List<Reponse> getAllActivated();
	Optional<Reponse> find(int id);
}
