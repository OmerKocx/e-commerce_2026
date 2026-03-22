package com.omerkoc.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omerkoc.product.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
