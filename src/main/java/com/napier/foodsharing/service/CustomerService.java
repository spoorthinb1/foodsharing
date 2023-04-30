package com.napier.foodsharing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napier.foodsharing.entity.Customer;
import com.napier.foodsharing.entity.SellerProfile;
import com.napier.foodsharing.repository.CustomerRepository;
import com.napier.foodsharing.repository.SellerProfileRepository;
import com.napier.foodsharing.util.PasswordDoesNotMatchException;
import com.napier.foodsharing.util.RecordNotFoundException;
import com.napier.foodsharing.util.UserExistsException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SellerProfileRepository sellerProfileRepository;

	public Customer registerUser(Customer cusomter) {
		Optional<Customer> customerDb = customerRepository.findById(cusomter.getUserId());
		if (customerDb.isPresent()) {
			throw new UserExistsException("User Id with already exists for" + cusomter.getUserId());
		} else {
			cusomter.setAccountStatus("Active");
			cusomter.setAdminUser(0);
			cusomter.setProfilePicture("image".getBytes());
			return customerRepository.save(cusomter);
		}
	}

	public Customer update(Customer customer) {
		Optional<Customer> customerDbOption = customerRepository.findById(customer.getUserId());
		if (customerDbOption.isPresent()) {
			Customer customerDb = customerDbOption.get();
			customerDb.setContactNumber(customer.getContactNumber());
			customerDb.setFirstName(customer.getFirstName());
			customerDb.setLastName(customer.getLastName());
			customerDb.setEmailId(customer.getEmailId());

			return customerRepository.save(customerDb);
		} else {

			throw new RecordNotFoundException("User not found for User id" + customer.getUserId());
		}
	}

	public Customer updatePassword(String userId, String oldPassword, String newPassword) {
		Optional<Customer> customerDbOption = customerRepository.findById(userId);
		if (customerDbOption.isPresent()) {
			Customer customerDb = customerDbOption.get();
			if (customerDb.getPassword().equals(oldPassword)) {
				customerDb.setPassword(newPassword);
			} else {
				throw new PasswordDoesNotMatchException("The old password does not match");
			}
			return customerRepository.save(customerDb);
		} else {
			throw new RecordNotFoundException("User not found for User id" + userId);
		}
	}

	public Customer getUser(String id) {
		Optional<Customer> customerDb = customerRepository.findById(id);
		if (customerDb.isPresent()) {
			return customerDb.get();
		} else {
			throw new RecordNotFoundException("User not found for User id" + id);
		}
	}

	public List<Customer> getAllUser() {
		return customerRepository.findAll();
	}

	public Customer login(String userId, String password) {
		Customer customer = customerRepository.findByUserIdAndPassword(userId, password);
		if (customer != null) {
			return customer;
		} else {
			throw new PasswordDoesNotMatchException("The old password does not match");
		}

	}

	public SellerProfile addSeller(SellerProfile seller) {
		return sellerProfileRepository.save(seller);
	}

}
