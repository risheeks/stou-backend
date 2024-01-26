package com.risheek.stou.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risheek.stou.repository.FoodRepository;
import com.risheek.stou.model.Food;

@Service
public class FoodService {
	private final FoodRepository foodRepository;
	
	@Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
	
	public List<Food> getAllFoods() {
		return foodRepository.findAll();
	}
}
