package com.napier.foodsharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {

	List<Notification> findByUserId(String userId);

	List<Notification> findByUserIdAndNotified(String userId, boolean read);

}
