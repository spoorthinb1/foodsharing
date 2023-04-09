package com.napier.foodsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
