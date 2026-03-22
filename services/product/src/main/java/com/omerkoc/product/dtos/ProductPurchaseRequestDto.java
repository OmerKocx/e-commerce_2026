package com.omerkoc.product.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record ProductPurchaseRequestDto(
        @NotNull(message = "Product id is required") Integer productId,
        @Positive(message = "Quantity is mandatory") double quantity) {
}
