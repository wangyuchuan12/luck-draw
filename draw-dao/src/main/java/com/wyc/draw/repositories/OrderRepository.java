package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.Order;

public interface OrderRepository extends CrudRepository<Order, String>{

}
