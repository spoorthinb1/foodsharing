package com.napier.foodsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napier.foodsharing.entity.ShareGroup;

public interface ShareGroupRepository extends JpaRepository<ShareGroup, String> {

}
