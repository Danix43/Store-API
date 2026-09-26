package com.danix43.Store.orders.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danix43.Store.orders.model.Order;
import java.util.List;
import java.sql.Date;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public Optional<Order> findByEmail(String email);

    public List<Order> findAllByDateOfPurchase(Date dateOfPurchase);
}
