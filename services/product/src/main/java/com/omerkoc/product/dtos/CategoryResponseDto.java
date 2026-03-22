package com.omerkoc.product.dtos;

import java.util.List;
import lombok.Builder;

@Builder
public record CategoryResponseDto(
        Integer id,
        String name,
        String description,
        List<ProductResponseDto> products) {
}
