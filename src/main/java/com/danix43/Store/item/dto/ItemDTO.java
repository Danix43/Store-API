package com.danix43.Store.item.dto;

import java.util.List;

import lombok.Data;

@Data
public class ItemDTO {

    private String name;

    private Double price;

    private List<String> images;
}