package com.napier.foodsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.Item;

public interface ItemRepository extends JpaRepository<Item, String> {

}
