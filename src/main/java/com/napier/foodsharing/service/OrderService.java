package com.napier.foodsharing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napier.foodsharing.controller.model.FeedBackSumary;
import com.napier.foodsharing.controller.model.OrderDetailsDTO;
import com.napier.foodsharing.controller.model.OrderSummaryDTO;
import com.napier.foodsharing.entity.Notification;
import com.napier.foodsharing.entity.OrderItem;
import com.napier.foodsharing.usecase.OrderUsecase;

@Service
public class OrderService {

	@Autowired
	private OrderUsecase orderUsecase;

	@Autowired
	private NotificationService notificationService;

	public OrderItem createOrder(List<OrderDetailsDTO> orderItems, String userId) {
		OrderItem order = orderUsecase.AddOrder(orderItems, userId);
		Notification notify = new Notification();
		notify.setLinkMessageOne(userId);
		notify.setLinkMessageTwo(order.getOrderId());
		notify.setMessage("You have recived a new order from");
		notify.setNotified(false);
		notify.setUserId(order.getSellerId());
		notificationService.saveNotification(notify);
		return order;
	}

	public List<OrderItem> getUserOrders(String userId) {
		return orderUsecase.getUserIOrders(userId);
	}

	public OrderSummaryDTO getOrderDetails(String orderId) {
		return orderUsecase.getOrderDetails(orderId);
	}

	public OrderItem addFeedBack(String orderId, String message, String rating) {
		return orderUsecase.addFeedback(orderId, message, rating);
	}

	public FeedBackSumary getFeedBack(String userId) {

		return orderUsecase.getFeedBack(userId);
	}

}
