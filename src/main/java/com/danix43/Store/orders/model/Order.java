package com.danix43.Store.orders.model;

import java.util.List;

import com.danix43.Store.item.model.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // general info
    private Long id;
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
