package com.napier.foodsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByUserIdAndPassword(String userId, String password);

}
