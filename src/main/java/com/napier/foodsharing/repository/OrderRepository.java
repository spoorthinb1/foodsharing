package com.napier.foodsharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.OrderItem;

public interface OrderRepository extends JpaRepository<OrderItem, String> {

	List<OrderItem> findByCustomerUserId(String userId);

	long countBySellerId(String userId);

	long countByCustomerUserId(String userId);

	List<OrderItem> findBySellerId(String userId);

}
