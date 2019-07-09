package com.recrutement.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class RecrutementSpringApplication  {
	
	public static void main(String[] args) throws NullPointerException{
		ApplicationContext applicationContext= SpringApplication.run(RecrutementSpringApplication.class, args);
	}
}


