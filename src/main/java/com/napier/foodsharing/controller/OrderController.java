package com.napier.foodsharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napier.foodsharing.controller.model.OrderDetailsDTO;
import com.napier.foodsharing.controller.model.OrderSummaryDTO;
import com.napier.foodsharing.entity.OrderItem;
import com.napier.foodsharing.service.OrderService;

@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public OrderItem addOrder(@RequestBody List<OrderDetailsDTO> orderItems, @RequestParam("userId") String userId) {
		return orderService.createOrder(orderItems, userId);
	}

	@GetMapping
	public List<OrderItem> getOrders(@RequestParam("userId") String userId) {
		return orderService.getUserOrders(userId);
	}

	@GetMapping("/details")
	public OrderSummaryDTO getOrderDetails(@RequestParam("orderId") String orderId) {
		return orderService.getOrderDetails(orderId);
	}
}
