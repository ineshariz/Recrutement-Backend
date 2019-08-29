package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recrutement.models.Candidat;

	public interface CandidatRepository extends JpaRepository<Candidat, Integer> {

}
