package com.recrutement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recrutement.dao.NotificationRepository;
import com.recrutement.dao.NotificationResponseRepository;
import com.recrutement.models.Notif;
import com.recrutement.models.NotificationReponse;

@Service(value= "notificationService")

public class NotificationServiceImpl implements NotificationService {
	@Autowired
	private NotificationRepository notifRepo;
	@Autowired
	private NotificationResponseRepository notificationRepo;
	@Override
	public Notif add(Notif notif) {
		notifRepo.save(notif);
		return notif;
	}
	@Override
	public List<Notif> getAll() {
		return notifRepo.findAll();
	}
	@Override
	public NotificationReponse addNotif(NotificationReponse notif) {
		notificationRepo.save(notif);
		return notif;
	}
	@Override
	public List<NotificationReponse> getAllNotif() {
		return notificationRepo.findAll();
}

}
