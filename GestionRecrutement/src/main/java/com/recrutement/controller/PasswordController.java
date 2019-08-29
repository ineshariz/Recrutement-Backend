package com.recrutement.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.recrutement.models.User;
import com.recrutement.service.MailService;
import com.recrutement.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pwd")
public class PasswordController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 @RequestMapping(value="/email/{email}", method = RequestMethod.GET)
	    public boolean requestPwd(@PathVariable String email) {
		System.out.println(email);
	    	return  userService.requestPwd(email);
		}
	 
	@RequestMapping(value = "/verifyToken/{token}", method = RequestMethod.GET)
	public ResponseEntity<User>   displayResetPasswordPage(@PathVariable String token) {
		Optional<User> user = userService.findUserByResetToken(token);
		if (user.isPresent()) { 
			return ResponseEntity.ok(user.get()); 
		}
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public boolean setNewPassword( @RequestBody List<String> params) {
		Optional<User> user = userService.findUserByResetToken(params.get(0));
		if (user.isPresent()) {
			User resetUser = user.get(); 
			resetUser.setEtat(true);
            resetUser.setPass(bCryptPasswordEncoder.encode(params.get(1)));
            resetUser.setResetToken(null);
            userService.addUser(resetUser);
            return true;
		} 
		return false;
   }
   
    
}
