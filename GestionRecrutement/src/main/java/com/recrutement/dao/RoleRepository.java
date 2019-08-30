package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recrutement.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
