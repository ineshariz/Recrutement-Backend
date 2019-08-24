package com.recrutement.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.recrutement.conf.JwtTokenUtil;
import com.recrutement.models.AuthToken;
import com.recrutement.models.Candidat;
import com.recrutement.models.LoginUser;
import com.recrutement.models.Role;
import com.recrutement.models.User;
import com.recrutement.service.RoleService;
import com.recrutement.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
	static RoleService roleService;
	
    @RequestMapping(value = "token/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Optional<User> user = userService.findByEmail(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user.get());
        return ResponseEntity.ok(new AuthToken(token));
    }
    
    @RequestMapping(value="inscription",method=RequestMethod.POST, produces = "application/json")
	public  ResponseEntity<?> addCandidat(@RequestBody Candidat candidat) {
    	LoginUser loginUser = new LoginUser(candidat.getEmail(), candidat.getPass());
		userService.addCandidat(candidat);
		final Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
        		loginUser.getUsername(),
                loginUser.getPassword()
			)
        );
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final Optional<User> user = userService.findByEmail(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user.get());
		return ResponseEntity.ok(new AuthToken(token)); 
	}
    
    @RequestMapping(value="/requestpwd/{email}", method = RequestMethod.GET)
    public boolean requestPwd(@PathVariable String email) {
    	return  userService.requestPwd(email);
	}
    
    
    @RequestMapping(value="/check", method = RequestMethod.GET)
    public ResponseEntity test() {
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public static final String endpoint = "http://ip-api.com/json";

    
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<User> getList(){
    	return userService.getListUser();
    	
    }

}
