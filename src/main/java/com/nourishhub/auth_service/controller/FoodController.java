package com.nourishhub.auth_service.controller;

import com.nourishhub.auth_service.entity.Food;
import com.nourishhub.auth_service.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodRepository foodRepository;

    @PostMapping("/add")
    public Food addFood(@RequestBody Food food) {

        return foodRepository.save(food);
    }

    @GetMapping
    public List<Food> getAllFoods() {

        return foodRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Food> getByCategory(
            @PathVariable String category
    ) {

        return foodRepository.findByCategory(category);
    }

    @GetMapping("/search")
    public List<Food> searchFood(
            @RequestParam String name
    ) {

        return foodRepository
                .findByNameContainingIgnoreCase(name);
    }
}