package com.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Category;
import com.app.repositories.CategoryRepository;
import com.app.services.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		Category category = optional.get();
		return category;
	}

	@Override
	public Category addNewCategory(Category category) {
		category.setCat_id(0);
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public String deleteCategory(int id) {
		categoryRepository.deleteById(id);
		return "Category Deleted";
	}
}
