package com.napier.foodsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, String> {

}
