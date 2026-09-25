package com.danix43.Store.orders.model;

import java.util.List;

import com.danix43.Store.item.dto.OrderItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @SequenceGenerator(name = "order_sequence", sequenceName = "orders_seq", initialValue = 1000, allocationSize = 1)
    private Long id;

    private String email;

    private String deliveryAddress;

    private String deliveryCity;

    private Integer deliveryPostalCode;

    private String deliveryCountry;

    private PaymentType paymentType;

    private String cardNumber;

    private String cardName;

    private String cardExpiry;

    @Column(name = "CARD_CVC")
    private Integer cardCVC;

    // @ManyToMany
    // @JoinTable(name = "order_products", joinColumns = @JoinColumn(name =
    // "order_id"), inverseJoinColumns = @JoinColumn(name = "products_id"))
    @ElementCollection
    private List<OrderItemDTO> products;

    private Double subtotal;
    private Double shipping;
    private Double total;
}
