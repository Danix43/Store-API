package com.danix43.Store.item.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderItemDTO {

    private String sku;
    private Integer qty;
}
