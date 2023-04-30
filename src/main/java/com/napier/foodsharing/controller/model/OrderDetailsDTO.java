package com.napier.foodsharing.controller.model;

import com.napier.foodsharing.entity.Item;

import lombok.Data;

@Data
public class OrderDetailsDTO {
	private String orderId;

	private String menuId;

	private int quantity;

	private double subTotal;

	private Item item;

}
