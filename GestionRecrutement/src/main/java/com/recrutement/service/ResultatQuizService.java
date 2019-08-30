package com.recrutement.service;

import java.util.List;
import com.recrutement.models.ResultatQuiz;

public interface ResultatQuizService {
	ResultatQuiz commit(ResultatQuiz resulatQuiz);
	List<ResultatQuiz> getAll();
	List<ResultatQuiz> getAllByDemandeId(int id);
}
