package com.napier.foodsharing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napier.foodsharing.entity.Notification;
import com.napier.foodsharing.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	public void saveNotification(Notification notification) {
		notificationRepository.save(notification);
	}

	public List<Notification> getUserNotification(String userId) {
		return notificationRepository.findByUserId(userId);
	}

	public List<Notification> getUnreadUserNotification(String userId) {
		return notificationRepository.findByUserIdAndNotified(userId, false);
	}

}
