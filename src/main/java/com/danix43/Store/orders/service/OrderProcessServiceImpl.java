package com.danix43.Store.orders.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danix43.Store.item.service.ItemProcessService;
import com.danix43.Store.item.service.ItemProcessServiceImpl;
import com.danix43.Store.orders.dto.OrderDTO;
import com.danix43.Store.orders.model.Order;
import com.danix43.Store.orders.repository.OrderRepository;

@Service
public class OrderProcessServiceImpl implements OrderProcessService {

    private Logger logger = LoggerFactory.getLogger(OrderProcessServiceImpl.class);

    private final ModelMapper modelMapper;

    private final OrderRepository orderRepository;
    private final ItemProcessService itemService;

    public OrderProcessServiceImpl(OrderRepository ordRepo, ItemProcessServiceImpl itmProcServ) {
        this.orderRepository = ordRepo;
        this.itemService = itmProcServ;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<OrderDTO> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .toList();
    }

    @Override
    public OrderDTO saveNewOrder(OrderDTO payload) {
        if (payload == null) {
            return null;
        }

        Order newOrder = modelMapper.map(payload, Order.class);
        newOrder.setId(null);

        Order savedOrder = orderRepository.save(newOrder);

        OrderDTO savedDto = modelMapper.map(savedOrder, OrderDTO.class);
        savedDto.setProducts(payload.getProducts());
        return savedDto;
    }

    @Override
    public Optional<OrderDTO> findOrderByEmail(String email) {
        Optional<Order> foundOrder = orderRepository.findByEmail(email);

        if (foundOrder.isPresent()) {
            return Optional.of(modelMapper.map(foundOrder, OrderDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public List<OrderDTO> findOrdersByDate(String dateInputed) {
        Date date = Date.valueOf(dateInputed);

        return orderRepository.findAllByDateOfPurchase(date)
                .stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .toList();
    }

    private Timestamp extractDateFromTimestamp(String dateInputed) {
        return null;
    }
}
