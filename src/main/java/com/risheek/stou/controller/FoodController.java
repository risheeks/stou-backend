package com.risheek.stou.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.risheek.stou.service.FoodService;
import com.risheek.stou.model.Food;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	private final FoodService foodService;
	
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
	
	@GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }
	
	@GetMapping("/{foodId}")
	public Optional<Food> getFoodById(@PathVariable Integer foodId) {
		return this.foodService.getFoodById(foodId);
	}
	
	@PostMapping()
	public Food createFood(@RequestBody Food food) {
		return this.foodService.createFood(food);
	}
	
	@PutMapping()
	public Food updateFood(@RequestBody Food food) {
		return this.foodService.updateFood(food);
	}
	
	@DeleteMapping("/{foodId}")
	public ResponseEntity<HttpStatus> deleteFood(@PathVariable Integer foodId) {
		if(this.foodService.deleteFood(foodId))
			return new ResponseEntity<>(HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
}
