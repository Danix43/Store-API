package com.danix43.Store.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danix43.Store.orders.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
