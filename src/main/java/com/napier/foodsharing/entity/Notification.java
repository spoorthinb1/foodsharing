package com.napier.foodsharing.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "notification_id")
	private String notificationId;

	private String message;

	private String linkMessageOne;

	private String linkMessageTwo;

	private boolean notified;

	@Column(name = "user_id")
	private String userId;

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isNotified() {
		return notified;
	}

	public void setNotified(boolean notified) {
		this.notified = notified;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLinkMessageOne() {
		return linkMessageOne;
	}

	public void setLinkMessageOne(String linkMessageOne) {
		this.linkMessageOne = linkMessageOne;
	}

	public String getLinkMessageTwo() {
		return linkMessageTwo;
	}

	public void setLinkMessageTwo(String linkMessageTwo) {
		this.linkMessageTwo = linkMessageTwo;
	}

}
