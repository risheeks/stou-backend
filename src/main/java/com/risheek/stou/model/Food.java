package com.risheek.stou.model;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	String foodId;
	String picture;
	@Column(name = "cook_email")
	String cookEmail;
	String title;
	String description;
	String cuisine;
	double price;
	int calories;
	boolean valid;
	
	public Food() {
		super();
	}

	public Food(String foodId, String picture, String cookEmail, String title, String description, String cuisine,
			double price, int calories, boolean valid) {
		super();
		this.foodId = foodId;
		this.picture = picture;
		this.cookEmail = cookEmail;
		this.title = title;
		this.description = description;
		this.cuisine = cuisine;
		this.price = price;
		this.calories = calories;
		this.valid = valid;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCookEmail() {
		return cookEmail;
	}

	public void setCookEmail(String cookEmail) {
		this.cookEmail = cookEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
