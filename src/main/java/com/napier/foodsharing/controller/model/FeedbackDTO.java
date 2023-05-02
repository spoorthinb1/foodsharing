package com.napier.foodsharing.controller.model;

import lombok.Data;

@Data
public class FeedbackDTO {

	private String userName;
	private String userId;
	private int rating;
	private String comment;

}
