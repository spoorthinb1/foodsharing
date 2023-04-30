package com.napier.foodsharing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napier.foodsharing.controller.model.MenuDTO;
import com.napier.foodsharing.entity.Category;
import com.napier.foodsharing.entity.Item;
import com.napier.foodsharing.entity.Menu;
import com.napier.foodsharing.entity.SellerProfile;
import com.napier.foodsharing.repository.CategoryRepository;
import com.napier.foodsharing.repository.ItemRepository;
import com.napier.foodsharing.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public Menu addMenu(MenuDTO menu) {
		return menuRepository.save(getMenu(menu));
	}

	public Item addItem(Item item) {
		item.setItemId("123");
		return itemRepository.save(item);
	}

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	public List<Category> getAllCatgory() {
		return categoryRepository.findAll();
	}

	public List<Menu> getAllMenu() {
		return menuRepository.findAll();
	}

	public List<Menu> getMenuByUser(String userId) {
		return menuRepository.findBySellerProfileProfileId(userId);
	}

	public List<Menu> getMenuByStatus(String status) {
		return menuRepository.findByStatus(status);
	}

	private Menu getMenu(MenuDTO menu) {
		return Menu.builder().availabilityTime(menu.getAvailabilityTime()).category(new Category(menu.getCategoryId()))
				.ingredients(menu.getIngredients()).item(new Item(menu.getItemId())).menuImage(menu.getMenuImage())
				.price(menu.getPrice()).quantity(menu.getQuantity()).recipe(menu.getRecipe())
				.sellerProfile(new SellerProfile(menu.getUserId())).sellingType(menu.getSellingType())
				.status(menu.getStatus()).build();
	}

	public Menu getMenuDetails(String menuID) {

		return menuRepository.findByMenuId(menuID);
	}
}
