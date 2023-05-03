package com.napier.foodsharing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napier.foodsharing.entity.Notification;
import com.napier.foodsharing.entity.OrderItem;
import com.napier.foodsharing.repository.NotificationRepository;
import com.napier.foodsharing.repository.OrderRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private OrderRepository orderRepository;

	public void saveNotification(Notification notification) {
		notificationRepository.save(notification);
	}

	public List<Notification> getUserNotification(String userId) {
		return notificationRepository.findByUserId(userId);
	}

	public List<Notification> getUnreadUserNotification(String userId) {
		return notificationRepository.findByUserIdAndNotified(userId, false);
	}

	public Notification markNotifiyAsRead(String notificationId) {
		Notification notifiy = notificationRepository.findById(notificationId).get();
		notifiy.setNotified(true);
		return notificationRepository.save(notifiy);
	}

	public List<OrderItem> sendNotifcations(String message, String orderId, String sellerId) {
		OrderItem order = orderRepository.findById(orderId).get();
		order.setOrderStatus("Complete");
		orderRepository.save(order);
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setLinkMessageOne(order.getSellerId());
		notification.setLinkMessageTwo(orderId);
		notification.setUserId(order.getCustomer().getUserId());
		notification.setNotified(false);
		notificationRepository.save(notification);
		return orderRepository.findBySellerId(sellerId);

	}

}
