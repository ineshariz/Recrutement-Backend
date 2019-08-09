package com.recrutement.service;

import java.util.List;
import java.util.Optional;
import com.recrutement.models.Question;

public interface QuestionService {
	Question commit(Question question);
	List<Question> getAll();
	List<Question> getAllActivated();
	Optional<Question> find(int id);
	List<Question> getAllByQuizId(int id);
	void delete(int id);
}
