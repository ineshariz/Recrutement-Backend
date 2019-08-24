package com.recrutement.service;

import java.util.List;
import java.util.Optional;

import com.recrutement.models.Quiz;
import com.recrutement.models.ResultatQuiz;

public interface ResultatQuizService {
	ResultatQuiz commit(ResultatQuiz resulatQuiz);
	List<ResultatQuiz> getAll();
	List<ResultatQuiz> getAllByDemandeId(int id);
}
