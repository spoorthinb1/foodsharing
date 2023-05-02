package com.napier.foodsharing.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "order_id")
	private String orderId;

	private String comment;

	@Column(name = "order_date_time")
	private Timestamp orderDateTime;

	private String rating;

	private String orderStatus;

	private String paymentStatus;

	private double total;

	@Column(name = "seller_id")
	private String sellerId;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer customer;

	// bi-directional many-to-one association to OrderDetail
	/*
	 * @OneToMany(mappedBy = "order") private List<OrderDetail> orderDetails;
	 */
	public OrderItem() {
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getOrderDateTime() {
		return this.orderDateTime;
	}

	public void setOrderDateTime(Timestamp orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

}