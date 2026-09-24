package com.danix43.Store.orders.dto;

import java.util.List;

import com.danix43.Store.item.model.Item;
import com.danix43.Store.orders.model.PaymentType;

import lombok.Data;

@Data
public class OrderDTO {

    private String email;

    // delivery info
    private String deliveryAddress;
    private String deliveryCity;
    private Integer deliveryPostalCode;
    private String deliveryCountry;

    // payment info
    private PaymentType paymentType;
    private String cardNumber;
    private String cardName;
    private String cardExpiry;
    private Integer cardCVC;

    // order info
    private List<Item> products;
    private Double subtotal;
    private Double shipping;
    private Double total;

}
