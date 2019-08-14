package com.recrutement.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.recrutement.models.Recruteur;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Integer>{	
	Optional<Recruteur> findByEmail(String email);
}
