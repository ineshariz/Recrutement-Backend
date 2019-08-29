package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recrutement.models.Notif;

	public interface NotificationRepository extends JpaRepository<Notif, Integer> {

}
