package com.recrutement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.QuestionRepository;
import com.recrutement.dao.QuizRepository;
import com.recrutement.models.Question;
import com.recrutement.models.Quiz;

@Service(value= "quizService")
public class QuizServiceImp implements QuizService {

	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	QuestionService questionService;
	
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

	@Override
	public Quiz enable(Quiz quiz) {
		System.out.println("QuizServiceImp.enable()");
		quiz.setActive(false);
		if (questionService.getAllByQuizId(quiz.getId()).size()>0){
			for (Question question : questionService.getAllByQuizId(quiz.getId())) {
				if (question.getReponses().size()>0){
					quiz.setActive(true);
					quizRepository.save(quiz);
					return quiz;
				}
			}
		}
		quizRepository.save(quiz);
		return quiz;
	}

	@Override
	public Quiz findByQuestion(Question question) {
		return questionRepository.findByQuestion(question).get();
	}

	
	
}
