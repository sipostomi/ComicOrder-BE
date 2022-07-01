package com.siposnet.comics.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.siposnet.comics.entity.Order;
import com.siposnet.comics.exception.ResourceNotFoundException;
import com.siposnet.comics.service.OrderServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class OrderController {

	private OrderServiceImpl orderServiceImpl;
	
	public OrderController(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}
	
	@GetMapping("orders")
	public List<Order> getAllOrders(){
		return orderServiceImpl.findAllOrders();
	}
	
	@PostMapping("orders")
	public Order createOrder(@RequestBody Order order) {
		return orderServiceImpl.save(order);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
		
		Order order = orderServiceImpl.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order is not exist with id" + id));
		
		return ResponseEntity.ok(order);
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails){
		
		Order order = orderServiceImpl.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order is not exist with id" + id));
		
		order.setName(orderDetails.getName());
		order.setEmail(orderDetails.getEmail());
		order.setAddress(orderDetails.getAddress());
		order.setPhoneNumber(orderDetails.getPhoneNumber());
		order.setPieces(orderDetails.getPieces());
		
		Order updateOrder = orderServiceImpl.save(order);
		
		return ResponseEntity.ok(updateOrder);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> deleteUser(@PathVariable ("id") Long id){
		 
		Order order = orderServiceImpl.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order is not exist with id" + id));
		
		orderServiceImpl.deleteOrder(order);
		 
		 return ResponseEntity.ok(order);
	}
}
