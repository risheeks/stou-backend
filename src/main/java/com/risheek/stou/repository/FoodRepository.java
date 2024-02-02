package com.risheek.stou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.risheek.stou.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	
	public List<Food> getFoodByCookEmail(String cookEmail);
}
