package com.omerkoc.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omerkoc.product.dtos.ProductPurchaseRequestDto;
import com.omerkoc.product.dtos.ProductPurchaseResponseDto;
import com.omerkoc.product.dtos.ProductRequestDto;
import com.omerkoc.product.dtos.ProductResponseDto;
import com.omerkoc.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequestDto request) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponseDto>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequestDto> request) {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponseDto> findById(
            @PathVariable("product-id") Integer productId) {
        return ResponseEntity.ok(service.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<Integer> updateProduct(
            @PathVariable("product-id") Integer productId,
            @RequestBody @Valid ProductRequestDto request) {
        return ResponseEntity.ok(service.updateProduct(productId, request));
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("product-id") Integer productId) {
        service.deleteProduct(productId);
        return ResponseEntity.accepted().build();
    }
}
