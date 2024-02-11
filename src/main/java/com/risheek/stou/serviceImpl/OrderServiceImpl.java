package com.risheek.stou.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risheek.stou.model.Order;
import com.risheek.stou.repository.OrderRepository;
import com.risheek.stou.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	@Override
	public List<Order> getAllOrders() {
		return this.orderRepository.findAll();
	}

	@Override
	public Optional<Order> getOrderById(Integer orderId) {
		if(this.orderRepository.existsById(orderId)) {
			return this.orderRepository.findById(orderId);
		}
		return null;
	}

	@Override
	public Order createOrder(Order order) {
//		order.setOrderId(order.getOrderId());
		return this.orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
		if(this.orderRepository.existsById(order.getOrderId()))
			return this.orderRepository.save(order);
		return null;
	}

	@Override
	public boolean deleteOrder(Integer orderId) {
		if(this.orderRepository.existsById(orderId)) {
			this.orderRepository.deleteById(orderId);
			return true;
		}
		return false;
	}
}