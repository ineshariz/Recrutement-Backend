package com.recrutement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.recrutement.models.Demande;
import com.recrutement.models.Question;
import com.recrutement.models.Quiz;
import com.recrutement.models.Reponse;
import com.recrutement.models.ResultatQuiz;
import com.recrutement.service.PostuleService;
import com.recrutement.service.QuestionService;
import com.recrutement.service.QuizService;
import com.recrutement.service.ReponseService;
import com.recrutement.service.ResultatQuizService;

@Controller
@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	PostuleService postuleService;
	
	@Autowired
	ResultatQuizService resultatQuizService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	ReponseService reponseService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Quiz> getListQuiz(){
		return quizService.getAll();
	}
	
	@RequestMapping(value="/activated", method=RequestMethod.GET)
	public List<Quiz> getListQuizActivated(){
		return quizService.getAllActivated();
	}
	
	@RequestMapping(value="/enable", method=RequestMethod.PUT)
	public Quiz enableQuiz(@RequestBody Quiz quiz){
		return quizService.enable(quiz);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Quiz updateQuiz(@RequestBody Quiz quiz){
		return quizService.commit(quiz);
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST, produces = "application/json")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return quizService.commit(quiz);
	}
	
	@RequestMapping(value="/{id}/question", method=RequestMethod.GET)
	public List<Question> getListQuestionByQuiz(@PathVariable int id){
		return questionService.getAllByQuizId(id);
	}
	
	@RequestMapping(value="/question", method=RequestMethod.POST)
	public Question addQuestionToQuiz(@RequestBody Question question){
		return questionService.commit(question);
	}
	
	@RequestMapping(value="/reponseQuiz/{demandeId}", method=RequestMethod.POST)
	public void reponseQuiz(@PathVariable int demandeId, @RequestBody Quiz submittedResult){
		System.out.println("hey "+submittedResult.getId());
		Demande demande= postuleService.find(demandeId);
		Quiz quizDB= quizService.find(submittedResult.getId()).get();
		int totalV=0;
		int point = 0;
		for (Question q : submittedResult.getQuestions()) {
			Question questionDB= questionService.find(q.getId()).get();
			totalV=totalV+questionDB.getValeur();
			int countDB=0;
			int count=0;
			for (Reponse r : questionDB.getReponses()) {
				Reponse reponseDB= reponseService.find(r.getId()).get();
				if (reponseDB.isValidate()==true)
					countDB++;
			}
			for (Reponse r : q.getReponses()) {
				Reponse reponseDB= reponseService.find(r.getId()).get();
				if (reponseDB.isValidate()==true)
					count++;	
			}
			if (count==countDB)
				point=point+questionDB.getValeur();
		}
		ResultatQuiz resultatQuiz= new ResultatQuiz();
		resultatQuiz.setQuiz(quizDB);
		resultatQuiz.setResultat((point*100)/totalV);
		resultatQuiz.setDemande(demande);
		resultatQuizService.commit(resultatQuiz);
	}
	
	@RequestMapping(value="/question/{id}", method=RequestMethod.DELETE)
	public void deleteQuestion(@PathVariable int id){
		Question question= questionService.find(id).get();
		questionService.delete(id);
		quizService.enable(question.getQuiz());
	}
	
	@RequestMapping(value="/{id}/question/{id}/reponse", method=RequestMethod.GET)
	public List<Reponse> getListReponseByQuestion(){
		return reponseService.getAll();
	}
	
	
}
