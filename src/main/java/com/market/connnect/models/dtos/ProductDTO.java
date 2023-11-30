package com.market.connnect.models.dtos;

import com.market.connnect.models.enums.ProductsCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @Min(0)
    private double price;
    private long availableQuantity;
    private ProductsCategory productsCategory;
}
