package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recrutement.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>


{

}
