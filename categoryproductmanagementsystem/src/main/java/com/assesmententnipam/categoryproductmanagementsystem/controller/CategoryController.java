package com.assesmententnipam.categoryproductmanagementsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.assesmententnipam.categoryproductmanagementsystem.dto.Category;
import com.assesmententnipam.categoryproductmanagementsystem.repository.CategoryRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	 @Autowired
	    private CategoryRepository categoryRepository;

	    @GetMapping 
	    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
	        return categoryRepository.findAll(PageRequest.of(page, 10));
	    }

	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryRepository.save(category);
	    }

	    @GetMapping("/{id}")
	    public Optional<Category> getCategoryById(@PathVariable Long id) {
	        return categoryRepository.findById(id);
	    }

	    @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        category.setId(id);
	        return categoryRepository.save(category);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCategory(@PathVariable Long id) {
	        categoryRepository.deleteById(id);
	    }

}
