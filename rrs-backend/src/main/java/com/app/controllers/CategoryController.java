package com.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Category;
import com.app.services.CategoryServiceInterface;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryServiceInterface categoryServiceInterface;

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryServiceInterface.getAllCategories();
	}

	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable int id) {

		return categoryServiceInterface.getCategory(id);
	}

	@PostMapping("/categories/add")
	public Category addNewCategory(@RequestBody Category category) {
		return categoryServiceInterface.addNewCategory(category);
	}

	@PutMapping("/categories/update")
	public Category updateCategory(@RequestBody Category category) {
		return categoryServiceInterface.updateCategory(category);
	}

	@DeleteMapping("/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		return categoryServiceInterface.deleteCategory(id);
	}
}
