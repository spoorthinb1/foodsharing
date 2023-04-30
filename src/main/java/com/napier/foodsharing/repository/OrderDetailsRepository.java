package com.napier.foodsharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.OrderDetail;
import com.napier.foodsharing.entity.OrderDetailPK;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

	List<OrderDetail> findByIdOrderId(String orderId);

}
