package com.recrutement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.dao.RoleRepostory;
import com.recrutement.models.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepostory roleRepository;

	

	@Override
	public List<Role> getListRole() {
		
		return roleRepository.findAll();
	}
	
	@Override
	public Role findById(Integer id) {
	    return roleRepository.getOne(id);
	    
	}

	
}
