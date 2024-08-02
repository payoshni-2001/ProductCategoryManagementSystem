package com.assesmententnipam.categoryproductmanagementsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.assesmententnipam.categoryproductmanagementsystem.dto.Product;
import com.assesmententnipam.categoryproductmanagementsystem.repository.ProductRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	 @Autowired
	    private ProductRepository productRepository;

	    @GetMapping
	    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) { 
	        return productRepository.findAll(PageRequest.of(page, 10));
	    }

	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return productRepository.save(product);
	    }

	    @GetMapping("/{id}")
	    public Optional<Product> getProductById(@PathVariable Long id) {
	        return productRepository.findById(id);
	    }

	    @PutMapping("/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        product.setId(id);
	        return productRepository.save(product);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productRepository.deleteById(id);
	    }

}
