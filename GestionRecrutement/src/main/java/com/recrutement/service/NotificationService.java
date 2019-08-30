package com.recrutement.service;

import java.util.List;
import com.recrutement.models.Notif;
import com.recrutement.models.NotificationReponse;

public interface NotificationService {
	Notif add(Notif choixdate);
	List<Notif> getAll();
	NotificationReponse addNotif(NotificationReponse notif);
	List<NotificationReponse> getAllNotif();


}
