package com.napier.foodsharing.controller.model;

import lombok.Data;

@Data
public class UpdatePasswordDto {

	private String userId;
	private String oldPassword;
	private String newPassword;
}
