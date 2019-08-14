package com.recrutement.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.recrutement.models.Candidat;
import com.recrutement.models.Quiz;
import com.recrutement.models.Recruteur;
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

	
	@RequestMapping(value="/pwd/{id}/{oldpwd}/{newpwd}",method=RequestMethod.GET)
    public boolean changePwd(@PathVariable int id, @PathVariable String oldpwd,@PathVariable String newpwd) {
		return userService.changePwd(id, oldpwd, newpwd);  
	}
	
	@RequestMapping(value="/recruteur/{email}",method=RequestMethod.GET)
    public Optional<Recruteur> findRecruteurbyEmail(@PathVariable String email) {
		return userService.findRecruteurByEmail(email);  
	}

	@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
    public User findbyId(@PathVariable Integer id) {
		System.out.println("test");
		System.out.println(id);
		return userService.findById(id);  
	}
	
	@RequestMapping(value="/recruteurs",method=RequestMethod.POST, produces = "application/json")
	public Recruteur addRecruteur(@RequestBody Recruteur recruteur) {
		return userService.addRecruteur(recruteur);
	}
	
	@RequestMapping(value="/recruteurs",method=RequestMethod.PUT, produces = "application/json")
	public Recruteur editRecruteur(@RequestBody Recruteur recruteur) {
		return userService.editRecruteur(recruteur);
	}
	
	@RequestMapping(value="/recruteurs",method=RequestMethod.GET, produces = "application/json")
	public List<Recruteur> listRecruteur() {
		return userService.getListRecruteur();
	}

	@RequestMapping(value="/nombrecandidat",method=RequestMethod.GET)
    public List<Number> nombrecandidat(@PathVariable Offre offre) {
		System.out.println("test");
		return userService.nombreCandidat(offre);  
	}
}