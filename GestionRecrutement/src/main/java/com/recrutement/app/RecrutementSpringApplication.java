package com.recrutement.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.recrutement.models.Candidat;
import com.recrutement.models.Recruteur;
import com.recrutement.models.User;
import com.recrutement.service.RoleService;
import com.recrutement.service.UserService;


@EnableWebSecurity
@EnableJpaAuditing
@SpringBootApplication
@EntityScan("com.recrutement.models")
@ComponentScan({"com.recrutement.service","com.recrutement.controller","com.recrutement.conf"})
@EnableJpaRepositories("com.recrutement.dao")
public class RecrutementSpringApplication implements CommandLineRunner {
	
	@Autowired
	static UserService us;
	
	@Autowired
	static RoleService rs;
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(RecrutementSpringApplication.class, args);
		
		/*
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		us=(UserService)applicationContext.getBean("userService");
		rs=(RoleService)applicationContext.getBean("roleService");
		Candidat c = new  Candidat();
		c.setDateNaissance(new Date());
		c.setEmail("c1");
		c.setNom("candi");
		c.setPrenom("c");
		c.setRole(rs.findById(3));
		c.setPass(bCryptPasswordEncoder.encode("123"));
		c.setPhoto("cool");
		c.setDateInscription(new Date());
		c.setCv("test");
		
		
		Recruteur r = new Recruteur();
		r.setDateNaissance(new Date());
		r.setEmail("r1");
		r.setNom("recrut");
		r.setPrenom("c");
		r.setRole(rs.findById(1));
		r.setPass(bCryptPasswordEncoder.encode("123"));
		r.setPhoto("cool");
		r.setDepartement("mobile");
		r.setDateRecrutement(new Date());
		
		
		us.addUser(c);
		us.addUser(r);
		*/
				
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}


}


