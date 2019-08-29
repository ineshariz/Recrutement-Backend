package com.recrutement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recrutement.models.NotificationReponse;

public interface NotificationResponseRepository extends JpaRepository<NotificationReponse, Integer>  {

}
