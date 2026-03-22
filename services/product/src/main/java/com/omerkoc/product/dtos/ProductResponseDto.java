package com.omerkoc.product.dtos;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record ProductResponseDto(
        Integer id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription) {
}
