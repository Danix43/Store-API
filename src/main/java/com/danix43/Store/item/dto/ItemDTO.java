package com.danix43.Store.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer reviewsQuantity;
    private Integer quantity;
    private String imageLink;
}