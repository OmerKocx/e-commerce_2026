package com.omerkoc.product.mapper;

import org.springframework.stereotype.Service;

import com.omerkoc.product.dtos.ProductPurchaseResponseDto;
import com.omerkoc.product.dtos.ProductRequestDto;
import com.omerkoc.product.dtos.ProductResponseDto;
import com.omerkoc.product.entities.Category;
import com.omerkoc.product.entities.Product;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequestDto request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(
                        Category.builder()
                                .id(request.categoryId())
                                .build())
                .build();
    }

    public ProductResponseDto toProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();
    }

    public ProductPurchaseResponseDto toProductPurchaseResponseDto(Product product, double quantity) {
        return ProductPurchaseResponseDto.builder()
                .productId(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(quantity)
                .build();
    }
}
