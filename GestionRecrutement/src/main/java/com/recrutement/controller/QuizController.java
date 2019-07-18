package com.recrutement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.recrutement.models.Question;
import com.recrutement.models.Quiz;
import com.recrutement.models.Reponse;
import com.recrutement.service.QuestionService;
import com.recrutement.service.QuizService;
import com.recrutement.service.ReponseService;

@Controller
@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	ReponseService reponseService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Quiz> getListQuiz(){
		return quizService.getAll();
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST, produces = "application/json")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return quizService.commit(quiz);
	}
	
	@RequestMapping(value="/{id}/question", method=RequestMethod.GET)
	public List<Question> getListQuestionByQuiz(){
		return questionService.getAll();
	}
	
	@RequestMapping(value="/{id}/question", method=RequestMethod.POST)
	public Question addQuestionToQuiz(@RequestBody Question question){
		return questionService.commit(question);
	}
	
	@RequestMapping(value="/{id}/question/{id}/reponse", method=RequestMethod.GET)
	public List<Reponse> getListReponseByQuestion(){
		return reponseService.getAll();
	}
	
	@RequestMapping(value="/{id}/question/{id}/reponse", method=RequestMethod.POST)
	public Reponse addReponseToQuestion(@RequestBody Reponse reponse){
		return reponseService.commit(reponse);
	}
	
}
