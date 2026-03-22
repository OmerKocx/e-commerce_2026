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

import com.omerkoc.product.dtos.CategoryRequestDto;
import com.omerkoc.product.dtos.CategoryResponseDto;
import com.omerkoc.product.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<Integer> createCategory(
            @RequestBody @Valid CategoryRequestDto request) {
        return ResponseEntity.ok(service.createCategory(request));
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<CategoryResponseDto> findById(
            @PathVariable("category-id") Integer categoryId) {
        return ResponseEntity.ok(service.findById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<Integer> updateCategory(
            @PathVariable("category-id") Integer categoryId,
            @RequestBody @Valid CategoryRequestDto request) {
        return ResponseEntity.ok(service.updateCategory(categoryId, request));
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity<Void> deleteCategory(
            @PathVariable("category-id") Integer categoryId) {
        service.deleteCategory(categoryId);
        return ResponseEntity.accepted().build();
    }
}
