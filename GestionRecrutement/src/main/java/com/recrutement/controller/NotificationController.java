package com.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutement.models.ChoixDateEntretien;
import com.recrutement.models.Demande;
import com.recrutement.models.Notif;
import com.recrutement.models.NotificationReponse;
import com.recrutement.service.NotificationService;
import com.recrutement.service.PostuleService;

@RestController
@RequestMapping("/notif")
@CrossOrigin("*")
public class NotificationController {
	@Autowired
	private NotificationService notificationService;
	@RequestMapping(value="/postule",method=RequestMethod.POST)
	public Notif addNotif(@RequestBody Notif notif) {
		
		notificationService.add(notif);
		return notif;
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Notif> getList(){
		return notificationService.getAll();
	}
	@RequestMapping(value="/changeetat",method=RequestMethod.PUT)
   	public Notif changeetat(@RequestBody Notif notif) {
			notif.setEtat(false);
		return notificationService.add(notif);
   }
	@RequestMapping(value="/Reponse",method=RequestMethod.POST)
	public NotificationReponse addNotification(@RequestBody NotificationReponse notif) {
		
		notificationService.addNotif(notif);
		return notif;
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<NotificationReponse> getListNotif(){
		return notificationService.getAllNotif();
	}
	@RequestMapping(value="/changeetatnotif",method=RequestMethod.PUT)
   	public NotificationReponse changeetatNotif(@RequestBody NotificationReponse notif) {
			notif.setEtat(false);
		return notificationService.addNotif(notif);
   }
}
