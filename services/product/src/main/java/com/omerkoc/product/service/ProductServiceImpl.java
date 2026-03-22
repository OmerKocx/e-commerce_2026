package com.omerkoc.product.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.omerkoc.product.entities.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omerkoc.product.dtos.ProductPurchaseRequestDto;
import com.omerkoc.product.dtos.ProductPurchaseResponseDto;
import com.omerkoc.product.dtos.ProductRequestDto;
import com.omerkoc.product.dtos.ProductResponseDto;
import com.omerkoc.product.exception.ProductNotFoundException;
import com.omerkoc.product.exception.ProductPurchaseException;
import com.omerkoc.product.mapper.ProductMapper;
import com.omerkoc.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public Integer createProduct(ProductRequestDto request) {
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    @Transactional(rollbackFor = ProductPurchaseException.class)
    @Override
    public List<ProductPurchaseResponseDto> purchaseProducts(List<ProductPurchaseRequestDto> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequestDto::productId)
                .toList();
        var storedProducts = repository.findAllById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequestDto::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponseDto>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException(
                        "Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);
            purchasedProducts.add(mapper.toProductPurchaseResponseDto(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponseDto findById(Integer productId) {
        return repository.findById(productId)
                .map(mapper::toProductResponseDto)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID:: " + productId));
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer updateProduct(Integer productId, ProductRequestDto request) {
        var product = repository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID:: " + productId));

        product.setName(request.name());
        product.setDescription(request.description());
        product.setAvailableQuantity(request.availableQuantity());
        product.setPrice(request.price());

        if (product.getCategory() == null || !product.getCategory().getId().equals(request.categoryId())) {
            var category = Category.builder()
                    .id(request.categoryId())
                    .build();
            product.setCategory(category);
        }

        return repository.save(product).getId();
    }

    @Override
    public void deleteProduct(Integer productId) {
        if (!repository.existsById(productId)) {
            throw new ProductNotFoundException("Product not found with ID:: " + productId);
        }
        repository.deleteById(productId);
    }
}
