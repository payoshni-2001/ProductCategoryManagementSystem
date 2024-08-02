package com.assesmententnipam.categoryproductmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesmententnipam.categoryproductmanagementsystem.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
 
}
