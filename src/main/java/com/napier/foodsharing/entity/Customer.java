package com.napier.foodsharing.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQuery;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "account_status")
	private String accountStatus;

	@Column(name = "address")
	private String address;

	@Column(name = "admin_user")
	private int adminUser;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Lob
	private String password;

	@Lob
	@Column(name = "profile_picture")
	private byte[] profilePicture = new byte[5];

	/*
	 * //bi-directional many-to-one association to Menu
	 * 
	 * @OneToMany(mappedBy="customer", fetch = FetchType.LAZY) private List<Menu>
	 * menus;
	 * 
	 * //bi-directional many-to-one association to Order
	 * 
	 * @OneToMany(mappedBy="customer", fetch = FetchType.LAZY) private List<Order>
	 * orders;
	 * 
	 * //bi-directional many-to-many association to ShareGroup
	 * 
	 * @ManyToMany(mappedBy="customers", fetch = FetchType.LAZY) private
	 * List<ShareGroup> shareGroups;
	 */

	public Customer() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(int adminUser) {
		this.adminUser = adminUser;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getProfilePicture() {
		return this.profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

}