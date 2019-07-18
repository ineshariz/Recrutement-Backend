package com.recrutement.service;

import java.util.List;
import java.util.Optional;

import com.recrutement.models.Quiz;

public interface QuizService {
	Quiz commit(Quiz quiz);
	Optional<Quiz> find(int id);
	List<Quiz> getAll();
	List<Quiz> getAllActivated();
}
