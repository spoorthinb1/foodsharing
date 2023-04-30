package com.napier.foodsharing.controller.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderSummaryDTO {

	String id;
	LocalDateTime date;
	String sellerName;
	String address;
	String city;
	String state;
	String zip;
	String paymentStatus;
	String orderStatus;
	double total;
	String comment;
	String rating;
	List<OrderDetailsDTO> orderItems;
}
