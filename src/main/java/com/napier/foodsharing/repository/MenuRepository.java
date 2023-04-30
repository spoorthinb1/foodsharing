package com.napier.foodsharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.napier.foodsharing.entity.Menu;

import jakarta.transaction.Transactional;

public interface MenuRepository extends JpaRepository<Menu, String> {

	List<Menu> findBySellerProfileProfileId(String userId);

	List<Menu> findByStatus(String status);

	Menu findByMenuId(String menuId);

	@Transactional
	@Modifying
	@Query(value = "update Menu m set m.quantity = :quantity where m.menuId = :menuId ")
	void updateQuanitity(@Param("quantity") int quantity, @Param("menuId") String menuId);

}
