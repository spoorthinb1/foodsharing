package com.napier.foodsharing.controller.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MenuDTO {

	private Timestamp availabilityTime;

	private String ingredients;

	private String menuImage;

	private double price;

	private int quantity;

	private String recipe;

	private String sellingType;

	private String status;

	private int categoryId;

	private String userId;

	private String itemId;

}
