package com.assesmententnipam.categoryproductmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesmententnipam.categoryproductmanagementsystem.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{ 

}
