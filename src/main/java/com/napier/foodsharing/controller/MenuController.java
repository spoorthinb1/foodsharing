package com.napier.foodsharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napier.foodsharing.controller.model.MenuDTO;
import com.napier.foodsharing.entity.Menu;
import com.napier.foodsharing.service.MenuService;

@RestController
@RequestMapping("api/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping
	public List<Menu> getAllMemu() {
		return menuService.getAllMenu();
	}

	@GetMapping("detail/{menuId}")
	public Menu getMenu(@PathVariable("menuId") String menuID) {
		return menuService.getMenuDetails(menuID);
	}

	@PostMapping
	public Menu saveMenu(@RequestBody MenuDTO menu) {
		menu.setMenuImage("image".getBytes());
		return menuService.addMenu(menu);
	}

	@GetMapping("/users")
	public List<Menu> getMenuByUserId(@RequestParam("userId") String userId) {
		return menuService.getMenuByUser(userId);
	}

	@GetMapping("/options")
	public List<Menu> getMenuByStatus(@RequestParam("status") String status) {
		return menuService.getMenuByStatus(status);
	}

}
