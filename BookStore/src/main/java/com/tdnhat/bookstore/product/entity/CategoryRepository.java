package com.tdnhat.bookstore.product.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Category repository interface
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}

