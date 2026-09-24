package com.danix43.Store.item.dto;

import com.danix43.Store.item.model.Categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private String sku;
    private String name;
    private Categories category;
    private Double price;
    private Integer qty;
    private String imageLink;
}