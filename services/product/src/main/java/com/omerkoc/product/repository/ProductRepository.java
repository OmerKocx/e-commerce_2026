package com.omerkoc.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omerkoc.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByIdInOrderById(List<Integer> ids);
}
