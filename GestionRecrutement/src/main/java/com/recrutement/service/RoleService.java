package com.recrutement.service;

import java.util.List;

import com.recrutement.models.Role;


public interface RoleService {
	List<Role> getListRole();
	 Role findById(Integer id);
	
}
