package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recrutement.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{
}
