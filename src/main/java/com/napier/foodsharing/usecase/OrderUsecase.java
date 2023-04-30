package com.napier.foodsharing.usecase;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napier.foodsharing.controller.model.OrderDetailsDTO;
import com.napier.foodsharing.controller.model.OrderSummaryDTO;
import com.napier.foodsharing.entity.Customer;
import com.napier.foodsharing.entity.Menu;
import com.napier.foodsharing.entity.OrderDetail;
import com.napier.foodsharing.entity.OrderDetailPK;
import com.napier.foodsharing.entity.OrderItem;
import com.napier.foodsharing.entity.SellerProfile;
import com.napier.foodsharing.repository.MenuRepository;
import com.napier.foodsharing.repository.OrderDetailsRepository;
import com.napier.foodsharing.repository.OrderRepository;
import com.napier.foodsharing.util.Constant;

@Component
public class OrderUsecase {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private MenuRepository menuRepository;

	public OrderItem AddOrder(List<OrderDetailsDTO> orderItems, String userId) {
		// Create OrderId
		OrderItem order = new OrderItem();
		order.setOrderStatus(Constant.IN_PROGRESS);
		order.setPaymentStatus(Constant.PENDING);
		order.setOrderDateTime(Timestamp.valueOf(LocalDateTime.now()));
		order.setTotal(orderItems.stream().map(e -> e.getSubTotal()).reduce(0.0, (a, b) -> a + b));
		Customer user = new Customer();
		user.setUserId(userId);
		order.setCustomer(user);
		order.setOrderId(UUID.randomUUID().toString());
		OrderItem db = orderRepository.save(order);

		List<OrderDetail> dbOrderDetails = orderItems.stream().map(o -> {
			OrderDetail details = new OrderDetail();
			details.setQuantity(o.getQuantity());
			details.setSubTotal(o.getSubTotal());
			details.setId(new OrderDetailPK(order.getOrderId(), o.getMenuId()));
			details.setOrder(order);
			return details;
		}).collect(Collectors.toList());

		orderDetailsRepository.saveAll(dbOrderDetails);

		orderItems.forEach(o -> {
			Menu menu = menuRepository.findById(o.getMenuId()).get();

			int currentQ = menu.getQuantity() - o.getQuantity();
			menuRepository.updateQuanitity(currentQ, userId);
		});

		return orderRepository.findById(db.getOrderId()).get();
	}

	public String findSellerId(String menuId) {
		return menuRepository.findById(menuId).get().getSellerProfile().getProfileId();
	}

	public List<OrderItem> getUserIOrders(String userId) {
		return orderRepository.findByCustomerUserId(userId);

	}

	public OrderSummaryDTO getOrderDetails(String orderId) {
		OrderItem order = orderRepository.findById(orderId).get();
		List<OrderDetail> orderDetail = orderDetailsRepository.findByIdOrderId(orderId);
		List<OrderDetailsDTO> detailDto = orderDetail.stream().map(o -> {
			OrderDetailsDTO dto = new OrderDetailsDTO();
			dto.setQuantity(o.getQuantity());
			dto.setSubTotal(o.getSubTotal());
			dto.setItem(menuRepository.findByMenuId(o.getId().getMenuId()).getItem());
			return dto;
		}).collect(Collectors.toList());
		SellerProfile profile = menuRepository.findById(orderDetail.get(0).getId().getMenuId()).get()
				.getSellerProfile();
		return OrderSummaryDTO.builder().id(order.getOrderId()).orderStatus(order.getOrderStatus())
				.paymentStatus(order.getPaymentStatus()).date(order.getOrderDateTime().toLocalDateTime())
				.orderItems(detailDto).sellerName(profile.getCustomer().getFirstName()).address(profile.getLocation())
				.total(order.getTotal()).comment(order.getComment()).rating(order.getRating()).build();

	}
}
