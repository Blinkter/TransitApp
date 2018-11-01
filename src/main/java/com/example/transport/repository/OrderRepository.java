package com.example.transport.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.transport.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
