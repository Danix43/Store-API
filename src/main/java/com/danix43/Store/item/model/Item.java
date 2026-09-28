package com.danix43.Store.item.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_seq", initialValue = 1000, allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer stockQty;

    @Column(unique = true)
    private String sku;

    @Enumerated(EnumType.STRING)
    private Categories category;

    private String description;

    private Double price;

    private String imageLink;
}
