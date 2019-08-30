package com.recrutement.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.ResultatQuizRepository;
import com.recrutement.models.ResultatQuiz;

@Service(value= "resultatQuizService")
public class ResultatQuizImp implements ResultatQuizService {

	@PersistenceContext()
	EntityManager em ;
	
	@Autowired
	ResultatQuizRepository resultatQuizRepository;
	
	@Override
	public ResultatQuiz commit(ResultatQuiz resulatQuiz) {
		return resultatQuizRepository.save(resulatQuiz);
	}

	@Override
	public List<ResultatQuiz> getAll() {
		return resultatQuizRepository.findAll();
	}

	@Override
	public List<ResultatQuiz> getAllByDemandeId(int id) {
		return resultatQuizRepository.findAll().stream()               
				.filter(resultatQuiz -> resultatQuiz.getDemande().getId()==id)   
				.collect(Collectors.toList());
	}

}
