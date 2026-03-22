package com.omerkoc.product.service;

import java.util.List;

import com.omerkoc.product.dtos.CategoryRequestDto;
import com.omerkoc.product.dtos.CategoryResponseDto;

public interface CategoryService {

    Integer createCategory(CategoryRequestDto request);

    CategoryResponseDto findById(Integer categoryId);

    List<CategoryResponseDto> findAll();

    Integer updateCategory(Integer categoryId, CategoryRequestDto request);

    void deleteCategory(Integer categoryId);
}
