package com.napier.foodsharing.controller.model;

import java.util.List;

import lombok.Data;

@Data
public class FeedBackSumary {

	private List<FeedbackDTO> feedbackDTO;
	private long orderCount;
	private long orderRecivedCount;

}
