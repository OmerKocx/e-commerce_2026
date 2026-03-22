package com.omerkoc.product.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CategoryRequestDto(
        @NotNull(message = "Category name is required") String name,
        @NotNull(message = "Category description is required") String description) {
}
