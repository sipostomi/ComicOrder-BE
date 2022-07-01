package com.siposnet.comics.service;

import java.util.List;
import java.util.Optional;

import com.siposnet.comics.entity.Order;

public interface OrderService {

	public List<Order> findAllOrders();
	
	public Optional<Order> findById(Long id);
	
	public Order save(Order order);
	
	public void deleteOrder(Order order);
	
	
}
