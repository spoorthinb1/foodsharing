package com.napier.foodsharing.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

	@NotNull(message = "The email address is required.")
	private String userId;

	private String accountStatus;

	private Boolean adminUser;

	@NotEmpty(message = "The full name is required.")
	@Size(min = 10, max = 12, message = "The length of Phone Number must be between 10 or 12 characters.")
	private String contactNumber;

	@NotEmpty(message = "The email address is required.")
	private String emailId;

	@NotEmpty(message = "The first name is required.")
	private String firstName;

	@NotEmpty(message = "The Last name is required.")
	private String lastName;

	@NotEmpty(message = "The Password is required.")
	private String password;

}
