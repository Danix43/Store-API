package com.danix43.Store.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {

    private String name;
    private String description;
    private Double price;
    private Integer reviewsQuantity;

}