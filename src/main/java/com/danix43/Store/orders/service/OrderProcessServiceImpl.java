package com.danix43.Store.orders.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danix43.Store.item.dto.ItemDTO;
import com.danix43.Store.item.model.Item;
import com.danix43.Store.item.repository.ItemRepository;
import com.danix43.Store.orders.dto.OrderDTO;
import com.danix43.Store.orders.model.Order;
import com.danix43.Store.orders.repository.OrderRepository;

@Service
public class OrderProcessServiceImpl implements OrderProcessService {

    private Logger logger = LoggerFactory.getLogger(OrderProcessServiceImpl.class);

    private final ModelMapper modelMapper;

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderProcessServiceImpl(OrderRepository ordRepo, ItemRepository itmRepo) {
        this.orderRepository = ordRepo;
        this.itemRepository = itmRepo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<OrderDTO> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .toList();
    }

    // FIXME fix this function
    @Override
    public OrderDTO saveNewOrder(OrderDTO payload) {
        if (payload == null) {
            return null;
        }

        Order newOrder = new Order();
        newOrder.setId(null);
        newOrder.setEmail(payload.getEmail());
        newOrder.setDeliveryAddress(payload.getDeliveryAddress());
        newOrder.setDeliveryCity(payload.getDeliveryCity());
        newOrder.setDeliveryPostalCode(payload.getDeliveryPostalCode());
        newOrder.setDeliveryCountry(payload.getDeliveryCountry());
        newOrder.setPaymentType(payload.getPaymentType());
        newOrder.setCardNumber(payload.getCardNumber());
        newOrder.setCardName(payload.getCardName());
        newOrder.setCardExpiry(payload.getCardExpiry());
        newOrder.setCardCVC(payload.getCardCVC());
        newOrder.setSubtotal(payload.getSubtotal());
        newOrder.setShipping(payload.getShipping());
        newOrder.setTotal(payload.getTotal());

        List<Item> orderProducts = payload.getProducts() == null ? List.of()
                : payload.getProducts().stream()
                        .map(product -> itemRepository.findBySku(product.getSku())
                                .orElseThrow(() -> new IllegalArgumentException(
                                        "Item not found for sku: " + product.getSku())))
                        .toList();

        newOrder.setProducts(orderProducts);

        Order savedOrder = orderRepository.save(newOrder);

        OrderDTO savedDto = modelMapper.map(savedOrder, OrderDTO.class);
        savedDto.setProducts(payload.getProducts());
        return savedDto;
    }
}
