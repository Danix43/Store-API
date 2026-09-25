package com.danix43.Store.orders.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danix43.Store.item.dto.OrderItemDTO;
import com.danix43.Store.item.model.Item;
import com.danix43.Store.item.repository.ItemRepository;
import com.danix43.Store.orders.dto.OrderDTO;
import com.danix43.Store.orders.model.Order;
import com.danix43.Store.orders.model.PaymentType;
import com.danix43.Store.orders.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
class OrderProcessServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private OrderProcessServiceImpl orderProcessService;

    @BeforeEach
    void setUp() {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setSku("SKU-1001");
        item1.setName("Keyboard");
        item1.setPrice(19.99);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setSku("SKU-1002");
        item2.setName("Mouse");
        item2.setPrice(29.99);

        when(itemRepository.findBySku("SKU-1001")).thenReturn(Optional.of(item1));
        when(itemRepository.findBySku("SKU-1002")).thenReturn(Optional.of(item2));
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> {
            Order order = invocation.getArgument(0);
            order.setId(99L);
            return order;
        });
    }

    @Test
    void saveNewOrder_shouldResolveProductsBySkuAndPersistOrder() {
        OrderItemDTO first = new OrderItemDTO();
        first.setSku("SKU-1001");
        first.setQty(1);

        OrderItemDTO second = new OrderItemDTO();
        second.setSku("SKU-1002");
        second.setQty(2);

        OrderDTO payload = new OrderDTO();
        payload.setEmail("mail@gmail.com");
        payload.setDeliveryAddress("strada");
        payload.setDeliveryCity("Oras");
        payload.setDeliveryPostalCode(1122);
        payload.setDeliveryCountry("France");
        payload.setPaymentType(PaymentType.CARD);
        payload.setCardNumber("1234 2154 5435 3535");
        payload.setCardName("Nume");
        payload.setCardExpiry("23/22");
        payload.setCardCVC(303);
        payload.setProducts(List.of(first, second));
        payload.setSubtotal(49.99);
        payload.setShipping(12.0);
        payload.setTotal(61.99);

        OrderDTO savedOrder = orderProcessService.saveNewOrder(payload);

        assertNotNull(savedOrder);
        assertEquals("mail@gmail.com", savedOrder.getEmail());
        assertEquals(2, savedOrder.getProducts().size());
        assertEquals("SKU-1001", savedOrder.getProducts().get(0).getSku());
        assertEquals(1, savedOrder.getProducts().get(0).getQty());
    }
}
