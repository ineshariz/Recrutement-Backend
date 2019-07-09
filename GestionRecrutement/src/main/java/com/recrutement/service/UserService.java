package com.recrutement.service;

import java.util.List;
import java.util.Optional;

import com.recrutement.models.User;

public interface UserService {
	
	User addUser(User user);
	
	List<User> getListUser();

	void deleteUser(Integer id);

	 User findById(Integer id);
	 	 
	 Optional<User> findByEmail(String nomPrenom);
}