package com.risheek.stou.model;

import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	public enum OrderStatus {
		PROCESSING,
		ACCEPTED,
		COOKING,
		DELIVERY,
		COMPLETED
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	Integer orderId;
	@NonNull
	@Column(name = "cook_email")
	String cookEmail;
	@NonNull
	@Column(name = "customer_email")
	String customerEmail;
	@Column(name = "delivery_address")
	String deliveryAddress;
	@Enumerated(EnumType.STRING)
	@Column(name="order_status")
	OrderStatus orderStatus;
	@ManyToMany
    List<Food> food;
	
	public Order() {
		super();
	}

	public Order(Integer orderId, @NonNull String cookEmail, @NonNull String customerEmail, String deliveryAddress,
			OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.cookEmail = cookEmail;
		this.customerEmail = customerEmail;
		this.deliveryAddress = deliveryAddress;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCookEmail() {
		return cookEmail;
	}

	public void setCookEmail(String cookEmail) {
		this.cookEmail = cookEmail;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public List<Food> getItems() {
		return food;
	}

	public void setItems(List<Food> items) {
		this.food = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cookEmail=" + cookEmail + ", customerEmail=" + customerEmail
				+ ", deliveryAddress=" + deliveryAddress + ", orderStatus=" + orderStatus + ", items=" + food + "]";
	}
}
