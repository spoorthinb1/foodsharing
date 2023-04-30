package com.napier.foodsharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napier.foodsharing.entity.Category;
import com.napier.foodsharing.service.MenuService;

@RestController
@RequestMapping("api/category")
public class CategoryContoller {

	@Autowired
	private MenuService menuService;

	@GetMapping
	public List<Category> getCategory() {
		return menuService.getAllCatgory();
	}
}
