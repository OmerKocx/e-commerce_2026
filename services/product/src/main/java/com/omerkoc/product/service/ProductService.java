package com.omerkoc.product.service;

import java.util.List;

import com.omerkoc.product.dtos.ProductPurchaseRequestDto;
import com.omerkoc.product.dtos.ProductPurchaseResponseDto;
import com.omerkoc.product.dtos.ProductRequestDto;
import com.omerkoc.product.dtos.ProductResponseDto;

public interface ProductService {

    Integer createProduct(ProductRequestDto request);

    List<ProductPurchaseResponseDto> purchaseProducts(List<ProductPurchaseRequestDto> request);

    ProductResponseDto findById(Integer productId);

    List<ProductResponseDto> findAll();

    Integer updateProduct(Integer productId, ProductRequestDto request);

    void deleteProduct(Integer productId);
}
