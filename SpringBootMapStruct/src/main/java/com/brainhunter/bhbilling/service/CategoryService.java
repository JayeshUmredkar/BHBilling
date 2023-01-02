package com.brainhunter.bhbilling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainhunter.bhbilling.entity.Category;
import com.brainhunter.bhbilling.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired(required = false)
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public String saveCategory(Category category) {
		categoryRepository.save(category);
		return "Category :- " + category.getName() + " added successfully!!";
	}

	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}

	public Optional<Category> getCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

	public String deleteCategoryById(int id) {
		categoryRepository.deleteById(id);
		return "Category removed ! Id:- " + id;
	}

	public Category updateCategory(Category category) {
		Category existingcategory = categoryRepository.findById(category.getId()).orElse(null);
		existingcategory.setName(category.getName());
		existingcategory.setCreatedAt(category.getCreatedAt());
		existingcategory.setUpdatedAt(category.getUpdatedAt());
		existingcategory.setDescription(category.getDescription());
		return categoryRepository.save(existingcategory);
	}
}
