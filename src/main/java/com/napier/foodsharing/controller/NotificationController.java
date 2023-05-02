package com.napier.foodsharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napier.foodsharing.entity.Notification;
import com.napier.foodsharing.entity.OrderItem;
import com.napier.foodsharing.service.NotificationService;

@RestController
@RequestMapping("api/notifiy")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@GetMapping()
	private List<Notification> getNotification(@RequestParam("userId") String userId) {
		return notificationService.getUnreadUserNotification(userId);
	}

	@GetMapping("/read")
	private Notification markAsread(@RequestParam("id") String notificationId) {
		return notificationService.markNotifiyAsRead(notificationId);
	}

	@GetMapping("/send")
	private List<OrderItem> sendNotification(@RequestParam("message") String message,
			@RequestParam("orderId") String orderId, @RequestParam("sellerId") String sellerId) {
		return notificationService.sendNotifcations(message, orderId, sellerId);
	}
}
