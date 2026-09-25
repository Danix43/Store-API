package com.danix43.Store.orders.service;

import java.util.List;
import java.util.Optional;

import com.danix43.Store.orders.dto.OrderDTO;

public interface OrderProcessService {

    public List<OrderDTO> getOrders();

    public OrderDTO saveNewOrder(OrderDTO payload);

    public Optional<OrderDTO> findOrderByEmail(String email);
}
