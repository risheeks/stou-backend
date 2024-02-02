package com.risheek.stou.service;

import java.util.List;
import java.util.Optional;

import com.risheek.stou.model.Food;

public interface FoodService {
	
	public List<Food> getAllFoods();
	
	public Optional<Food> getFoodById(Integer foodId);
	
	public List<Food> getFoodsByCook(String cookEmail);
	
	public Food createFood(Food food);
	
	public Food updateFood(Food food);

	public boolean deleteFood(Integer foodId);
}
