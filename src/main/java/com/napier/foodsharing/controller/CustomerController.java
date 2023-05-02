package com.napier.foodsharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napier.foodsharing.controller.model.LoginUser;
import com.napier.foodsharing.controller.model.UpdatePasswordDto;
import com.napier.foodsharing.entity.Customer;
import com.napier.foodsharing.entity.SellerProfile;
import com.napier.foodsharing.service.CustomerService;

@RestController
@RequestMapping("api/user")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	public Customer register(@RequestBody Customer customer) {
		return customerService.registerUser(customer);
	}

	@PutMapping()
	public Customer update(@RequestBody Customer customer) {
		return customerService.update(customer);
	}

	@PutMapping("/updatepassword")
	public Customer update(@RequestBody UpdatePasswordDto passwordDto) {
		return customerService.updatePassword(passwordDto.getUserId(), passwordDto.getOldPassword(),
				passwordDto.getNewPassword());
	}

	@GetMapping("/{id}")
	public Customer getUser(@PathVariable String id) {
		return customerService.getUser(id);
	}

	@GetMapping()
	public List<Customer> getAllUsers() {
		return customerService.getAllUser();
	}

	@PostMapping("/login")
	public Customer login(@RequestBody LoginUser login) {
		return customerService.login(login.getUserId(), login.getPassword());
	}

	@GetMapping("/seller/{sellerId}")
	public SellerProfile getSeller(@PathVariable("sellerId") String sellerId) {
		return customerService.getSeller(sellerId);
	}

	@PostMapping("/seller")
	public SellerProfile saveSeller(@RequestBody SellerProfile sellerProfile) {
		return customerService.addSeller(sellerProfile);
	}

}
