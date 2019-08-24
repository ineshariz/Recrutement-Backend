package com.recrutement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service(value= "mailService")
public class MailServiceImp implements MailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendEmail(SimpleMailMessage email) {
		mailSender.send(email);
		
	}

}
