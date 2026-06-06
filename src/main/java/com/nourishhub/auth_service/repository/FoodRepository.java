package com.nourishhub.auth_service.repository;

import com.nourishhub.auth_service.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository
        extends JpaRepository<Food, Long> {

    List<Food> findByCategory(String category);

    List<Food> findByNameContainingIgnoreCase(String name);
}