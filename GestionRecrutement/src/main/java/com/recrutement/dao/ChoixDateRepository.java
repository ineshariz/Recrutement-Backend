package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recrutement.models.ChoixDateEntretien;

public interface ChoixDateRepository extends JpaRepository<ChoixDateEntretien, Integer> {

}