package com.danix43.Store.orders.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danix43.Store.orders.dto.OrderDTO;
import com.danix43.Store.orders.service.OrderProcessService;
import com.danix43.Store.orders.service.OrderProcessServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    private final OrderProcessService orderService;

    public OrdersController(OrderProcessServiceImpl ordService) {
        this.orderService = ordService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getOrder() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/order")
    public ResponseEntity<OrderDTO> getOrderByEmail(@RequestParam String email) {
        return ResponseEntity.ok(orderService.findOrderByEmail(email).get());
    }

    @PostMapping("/newOrder")
    public ResponseEntity<OrderDTO> postNewOrder(@RequestBody OrderDTO entity) {
        return ResponseEntity.ok(orderService.saveNewOrder(entity));
    }

}
