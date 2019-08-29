package com.recrutement.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.recrutement.models.Question;
import com.recrutement.models.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	Optional<Quiz> findByQuestion(Question question);
}
