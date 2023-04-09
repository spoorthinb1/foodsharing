package com.napier.foodsharing.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_id")
	private String menuId;

	@Column(name="availability_time")
	private Timestamp availabilityTime;

	private String ingredients;

	@Lob
	@Column(name="menu_image")
	private byte[] menuImage;

	@Lob
	private byte[] price;

	private int quantity;

	private String recipe;

	@Column(name="selling_type")
	private String sellingType;

	private String status;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="item_id")
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

	public byte[] getPrice() {
		return this.price;
	}

	public void setPrice(byte[] price) {
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

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}