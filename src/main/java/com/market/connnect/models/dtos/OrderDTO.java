package com.market.connnect.models.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String address;
    private double orderValue;
}
