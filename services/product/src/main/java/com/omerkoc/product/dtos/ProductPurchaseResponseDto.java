package com.omerkoc.product.dtos;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record ProductPurchaseResponseDto(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity) {
}
