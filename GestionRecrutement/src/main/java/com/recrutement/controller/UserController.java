package com.recrutement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.models.User;
import com.recrutement.service.UserService;


@Controller
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/email/{email}",method=RequestMethod.GET)
    public Optional<User> findbyEmail(@PathVariable String email) {
		return userService.findByEmail(email);  
	}

}
