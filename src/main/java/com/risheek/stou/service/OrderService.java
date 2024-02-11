package com.risheek.stou.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.risheek.stou.model.Order;

@Service
public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public Optional<Order> getOrderById(Integer orderId);
	
	public Order createOrder(Order order);
	
	public Order updateOrder(Order order);

	public boolean deleteOrder(Integer orderId);
}