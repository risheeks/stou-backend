package com.risheek.stou.model;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	Integer foodId;
	String picture; 
	@NonNull
	@Column(name = "cook_email")	
	String cookEmail;
	@NonNull
	String title;
	String description;
	String cuisine;
	@NonNull
	Double price;
	Integer calories;
	@NonNull
	Boolean valid;
	
	public Food() {
		super();
	}

	public Food(Integer foodId, String picture, String cookEmail, String title, String description, String cuisine,
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

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
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
	

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", picture=" + picture + ", cookEmail=" + cookEmail + ", title=" + title
				+ ", description=" + description + ", cuisine=" + cuisine + ", price=" + price + ", calories="
				+ calories + ", valid=" + valid + "]";
	}
	
}
