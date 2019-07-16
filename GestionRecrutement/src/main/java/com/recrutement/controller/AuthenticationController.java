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
import com.recrutement.models.LoginUser;
import com.recrutement.models.User;
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

    
    @RequestMapping(value = "token/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	System.out.println("hey u");
    	System.out.println(loginUser.getUsername());
    	System.out.println(loginUser.getPassword());

          final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Optional<User> user = userService.findByEmail(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user.get());
        System.out.println(token);
        return ResponseEntity.ok(new AuthToken(token));
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
