package com.recrutement.service;

import java.util.List;
import com.recrutement.models.Demande;

public interface PostuleService {
	Demande add(Demande demande);
	List<Demande> getAll();
	List<Demande>getDemandeParOffre(int id);
	Demande find(int id);
	List<Demande> getDemandeParCandidat(int id);
	Demande getDemandeParCandidatoffre(int id,int id1);
	boolean checkDemandeExistByAnOffer(int offreId, int userID);
}
