package com.napier.foodsharing.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller_profile")
@NamedQuery(name = "SellerProfile.findAll", query = "SELECT s FROM SellerProfile s")
public class SellerProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String profileId;
	private String about;
	private String location;
	private String rating;
	// private List<Menu> menus;
	private Customer customer;

	public SellerProfile() {
	}

	public SellerProfile(String profileId) {
		super();
		this.profileId = profileId;
	}

	@Id
	@Column(name = "profile_id")
	public String getProfileId() {
		return this.profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	// bi-directional one-to-one association to Customer
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}