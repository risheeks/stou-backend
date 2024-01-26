package com.risheek.stou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.risheek.stou.model.Food;

public interface FoodRepository extends JpaRepository<Food, String> {

}
