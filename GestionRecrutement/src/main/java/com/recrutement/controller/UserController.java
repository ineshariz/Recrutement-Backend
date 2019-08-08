package com.recrutement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.models.Offre;
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
	@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
    public User findbyId(@PathVariable Integer id) {
		System.out.println("test");
		System.out.println(id);

		return userService.findById(id);  
	}
	
	@RequestMapping(value="/nombrecandidat",method=RequestMethod.GET)
    public List<Number> nombrecandidat(@PathVariable Offre offre) {
		System.out.println("test");
		return userService.nombreCandidat(offre);  
}
}