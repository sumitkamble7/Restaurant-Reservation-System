package com.app.services;

import java.util.List;

import com.app.entities.Category;



public interface CategoryServiceInterface {

	// get all category
	public List<Category> getAllCategories();

	// get specific category
	public Category getCategory(int id);

	// add new category
	public Category addNewCategory(Category category);

	// update existing category
	public Category updateCategory(Category category);

	// delete category
	public String deleteCategory(int id);
}
