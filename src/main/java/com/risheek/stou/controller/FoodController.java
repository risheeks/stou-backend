package com.risheek.stou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.risheek.stou.service.FoodService;
import com.risheek.stou.model.Food;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	private final FoodService foodService;
	
	@Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
	
	@GetMapping
    public List<Food> getAllUsers() {
        return foodService.getAllFoods();
    }
}
