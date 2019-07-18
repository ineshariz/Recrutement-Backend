package com.recrutement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.QuizRepository;
import com.recrutement.models.Quiz;

@Service(value= "quizService")
public class QuizServiceImp implements QuizService {

	@Autowired
	QuizRepository quizRepository;
	
	@Override
	public Quiz commit(Quiz quiz) {
		quizRepository.save(quiz);
		return quiz;
	}

	@Override
	public Optional<Quiz> find(int id) {
		return quizRepository.findById(id);
	}

	@Override
	public List<Quiz> getAll() {
		return quizRepository.findAll();
	}

	@Override
	public List<Quiz> getAllActivated() {
		return quizRepository.findAll().stream()               
				.filter(quiz -> quiz.isActive()==true)   
				.collect(Collectors.toList());
	}

	

	
}
