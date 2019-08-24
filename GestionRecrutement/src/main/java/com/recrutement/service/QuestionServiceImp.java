package com.recrutement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.QuestionRepository;
import com.recrutement.dao.ReponseRepository;
import com.recrutement.models.Question;
import com.recrutement.models.Reponse;

@Service(value= "questionService")
public class QuestionServiceImp implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	ReponseRepository reponseRepository;
	
	@Override
	public Question commit(Question question) {
		questionRepository.save(question);
		for (Reponse item : question.getReponses()) {
			item.setQuestion(question);
			reponseRepository.save(item);
		}
		return question;
	}

	@Override
	public List<Question> getAll() {
		return questionRepository.findAll();
	}

	@Override
	public List<Question> getAllActivated() {
		return questionRepository.findAll().stream()               
				.filter(question -> question.isActive()==true)   
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Question> getAllByQuizId(int id) {
		return questionRepository.findAll().stream()               
				.filter(question -> question.getQuiz().getId()==id)   
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Question> find(int id) {
		return questionRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		questionRepository.deleteById(id);
	}

	
}
