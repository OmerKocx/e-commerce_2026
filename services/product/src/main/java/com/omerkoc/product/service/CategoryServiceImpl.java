package com.omerkoc.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.omerkoc.product.dtos.CategoryRequestDto;
import com.omerkoc.product.dtos.CategoryResponseDto;
import com.omerkoc.product.exception.CategoryNotFoundException;
import com.omerkoc.product.mapper.CategoryMapper;
import com.omerkoc.product.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public Integer createCategory(CategoryRequestDto request) {
        var category = mapper.toCategory(request);
        return repository.save(category).getId();
    }

    @Override
    public CategoryResponseDto findById(Integer categoryId) {
        return repository.findById(categoryId)
                .map(mapper::toCategoryResponseDto)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID:: " + categoryId));
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toCategoryResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer updateCategory(Integer categoryId, CategoryRequestDto request) {
        var category = repository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID:: " + categoryId));

        category.setName(request.name());
        category.setDescription(request.description());

        return repository.save(category).getId();
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        if (!repository.existsById(categoryId)) {
            throw new CategoryNotFoundException("Category not found with ID:: " + categoryId);
        }
        repository.deleteById(categoryId);
    }
}
