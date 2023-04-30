package com.napier.foodsharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napier.foodsharing.entity.Item;
import com.napier.foodsharing.service.MenuService;

@RestController
@RequestMapping("api/item")
public class ItemController {
	
	@Autowired
	private MenuService menuService;

	@PostMapping
	public Item add(@RequestBody Item item) {
		return menuService.addItem(item);
	}
	
	@GetMapping
	public List<Item> getItems() {
		return menuService.getAllItems();
	}
}
