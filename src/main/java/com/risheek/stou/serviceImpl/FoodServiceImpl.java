package com.risheek.stou.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risheek.stou.model.Food;
import com.risheek.stou.repository.FoodRepository;
import com.risheek.stou.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private final FoodRepository foodRepository;

	public FoodServiceImpl(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	@Override
	public List<Food> getAllFoods() {
		return this.foodRepository.findAll();
	}

	@Override
	public Optional<Food> getFoodById(Integer foodId) {
		if(this.foodRepository.existsById(foodId)) {
			return this.foodRepository.findById(foodId);
		}
		return null;
	}

	@Override
	public List<Food> getFoodsByCook(String cookEmail) {
		return this.foodRepository.getFoodByCookEmail(cookEmail);
	}

	@Override
	public Food createFood(Food food) {
		food.setFoodId(food.getFoodId());
		System.out.println(food);
		return this.foodRepository.save(food);
	}

	@Override
	public Food updateFood(Food food) {
		if(this.foodRepository.existsById(food.getFoodId()))
			return this.foodRepository.save(food);
		return null;
	}

	@Override
	public boolean deleteFood(Integer foodId) {
		if(this.foodRepository.existsById(foodId)) {
			this.foodRepository.deleteById(foodId);
			return true;
		}
		return false;
	}

}
