package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Order;
import com.wyc.draw.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void add(Order order) {
		order.setId(UUID.randomUUID().toString());
		order.setUpdateAt(new DateTime());
		order.setCreateAt(new DateTime());
		
		orderRepository.save(order);
		
	}

	public void update(Order order) {
		
		order.setUpdateAt(new DateTime());
		orderRepository.save(order);
		
	}

	public Order findOne(String id) {
		
		return orderRepository.findOne(id);
	}
}
