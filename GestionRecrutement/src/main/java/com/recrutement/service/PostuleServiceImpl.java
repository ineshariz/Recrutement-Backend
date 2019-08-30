package com.recrutement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.DemandeRepository;
import com.recrutement.models.Demande;

@Service(value= "postuleService")

public class PostuleServiceImpl implements PostuleService {
 
	
	@Autowired
	private DemandeRepository demandeRepo;

	@Override
	public Demande add(Demande demande) {
		demandeRepo.save(demande);
		return demande;
	}

	@Override
	public List<Demande> getAll() {
		return demandeRepo.findAll();
	}

	@Override
	public List<Demande> getDemandeParOffre(int id) {
		return demandeRepo.findAll().stream()               
				.filter(demande -> demande.getOffre().getId()==id)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Demande> getDemandeParCandidat(int id) {
		return demandeRepo.findAll().stream()               
				.filter(demande -> demande.getCandidat().getId()==id)
				.collect(Collectors.toList());
	}

	@Override
	public Demande find(int id) {
			return demandeRepo.getOne(id);
		
	}

	@Override
	public Demande getDemandeParCandidatoffre(int id, int id1) {
		return demandeRepo.findAll().stream()               
				.filter(demande -> demande.getCandidat().getId()==id && demande.getOffre().getId()==id1).findFirst().get();
	}


	@Override
	public boolean checkDemandeExistByAnOffer(int offreId, int userId) {
		for (Demande demande : demandeRepo.findAll()) {
			if(demande.getOffre().getId()==offreId && demande.getCandidat().getId()==userId)
				return true;
		}
		return false;
	}

	
	
}
