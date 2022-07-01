package com.siposnet.comics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siposnet.comics.entity.Order;
import com.siposnet.comics.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Order order) {
		orderRepository.delete(order);
		
	}
	
	
}
