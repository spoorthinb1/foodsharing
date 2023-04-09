package com.napier.foodsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

}
