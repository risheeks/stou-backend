package com.risheek.stou.model;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_food")
public class OrderFood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_food_id")
	Integer orderFoodId;
	@NonNull
	@Column(name = "order_id")
	Integer orderId;
	@NonNull
	@Column(name = "food_id")
	Integer foodId;
	@NonNull
	Integer quantity;
	
	public OrderFood() {
		super();
	}

	public OrderFood(Integer orderFoodId, @NonNull Integer orderId, @NonNull Integer foodId,
			@NonNull Integer quantity) {
		super();
		this.orderFoodId = orderFoodId;
		this.orderId = orderId;
		this.foodId = foodId;
		this.quantity = quantity;
	}

	public Integer getOrderFoodId() {
		return orderFoodId;
	}

	public void setOrderFoodId(Integer orderFoodId) {
		this.orderFoodId = orderFoodId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderFood [orderFoodId=" + orderFoodId + ", OrderId=" + orderId + ", foodId=" + foodId + ", quantity="
				+ quantity + "]";
	}
}
