package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recrutement.models.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Integer>


{

}
