package com.risheek.stou.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.risheek.stou.model.Order;
import com.risheek.stou.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;
	
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
	
	@GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
	
	@GetMapping("/{orderId}")
	public Optional<Order> getOrderById(@PathVariable Integer orderId) {
		return this.orderService.getOrderById(orderId);
	}
	
	@PostMapping()
	public Order createOrder(@RequestBody Order order) {
		System.out.println(order);
		return this.orderService.createOrder(order);
	}
	
	@PutMapping()
	public Order updateOrder(@RequestBody Order order) {
		return this.orderService.updateOrder(order);
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Integer orderId) {
		if(this.orderService.deleteOrder(orderId))
			return new ResponseEntity<>(HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}