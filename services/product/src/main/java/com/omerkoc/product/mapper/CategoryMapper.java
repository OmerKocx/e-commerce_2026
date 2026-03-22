package com.omerkoc.product.mapper;

import org.springframework.stereotype.Service;

import com.omerkoc.product.dtos.CategoryRequestDto;
import com.omerkoc.product.dtos.CategoryResponseDto;
import com.omerkoc.product.entities.Category;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryMapper {
    private final ProductMapper productMapper;

    public Category toCategory(CategoryRequestDto request) {
        return Category.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    public CategoryResponseDto toCategoryResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .products(category.getProducts() != null ? category.getProducts().stream()
                        .map(productMapper::toProductResponseDto)
                        .collect(Collectors.toList()) : null)
                .build();
    }
}
