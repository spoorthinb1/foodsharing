package com.napier.foodsharing.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Builder
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "menu_id")
	private String menuId;

	@Column(name = "availability_time")
	private Timestamp availabilityTime;

	private String ingredients;

	@Lob
	@Column(name = "menu_image")
	private byte[] menuImage;

	private double price;

	private int quantity;

	private String recipe;

	@Column(name = "selling_type")
	private String sellingType;

	private String status;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "user_id")
	private SellerProfile sellerProfile;

	// bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	public Menu() {
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public Timestamp getAvailabilityTime() {
		return this.availabilityTime;
	}

	public void setAvailabilityTime(Timestamp availabilityTime) {
		this.availabilityTime = availabilityTime;
	}

	public String getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public byte[] getMenuImage() {
		return this.menuImage;
	}

	public void setMenuImage(byte[] menuImage) {
		this.menuImage = menuImage;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRecipe() {
		return this.recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getSellingType() {
		return this.sellingType;
	}

	public void setSellingType(String sellingType) {
		this.sellingType = sellingType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public SellerProfile getSellerProfile() {
		return sellerProfile;
	}

	public void setSellerProfile(SellerProfile sellerProfile) {
		this.sellerProfile = sellerProfile;
	}

	public Menu(String menuId, Timestamp availabilityTime, String ingredients, byte[] menuImage, double price,
			int quantity, String recipe, String sellingType, String status, Category category,
			SellerProfile sellerProfile, Item item) {
		super();
		this.menuId = menuId;
		this.availabilityTime = availabilityTime;
		this.ingredients = ingredients;
		this.menuImage = menuImage;
		this.price = price;
		this.quantity = quantity;
		this.recipe = recipe;
		this.sellingType = sellingType;
		this.status = status;
		this.category = category;
		this.sellerProfile = sellerProfile;
		this.item = item;
	}

}