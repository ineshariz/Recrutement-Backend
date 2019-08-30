package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recrutement.models.Offre;

public interface OffreRepository extends JpaRepository<Offre, Integer>{

}
