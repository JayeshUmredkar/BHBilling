package com.brainhunter.bhbilling.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainhunter.bhbilling.dto.CategoryDto;
import com.brainhunter.bhbilling.entity.Category;
import com.brainhunter.bhbilling.mapper.CategoryMapper;
import com.brainhunter.bhbilling.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired(required = false)
	private CategoryService categoryService;

	@Autowired(required = false)
	private CategoryMapper categoryMapper;

	@PostMapping("/add")
	public String createCategory(@RequestBody CategoryDto categoryDto) {
		System.out.println(categoryDto);
		Category category = categoryMapper.toCategory(categoryDto);
		System.out.println("categoryMapper = " + categoryMapper);
		System.out.println(category);
		System.out.println("categoryService = " + categoryService);
		return categoryService.saveCategory(category);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<CategoryDto> findCategoryById(@PathVariable int id) {
		Optional<Category> category = categoryService.getCategoryById(id);
		CategoryDto categoryDto = categoryMapper.toCategoryDto(category.get());
		return ResponseEntity.ok(categoryDto);
	}

	@GetMapping("/getByName/{name}")
	public ResponseEntity<CategoryDto> findCategoryByName(@PathVariable String name) {
		Optional<Category> category = categoryService.getCategoryByName(name);
		CategoryDto categoryDto = categoryMapper.toCategoryDto(category.get());
		return ResponseEntity.ok(categoryDto);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryDto> update(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
		Category category = categoryMapper.toCategory(categoryDto);
		category.setId(id);
		categoryService.updateCategory(category);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryDto);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return categoryService.deleteCategoryById(id);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>> findAll() {
		List<CategoryDto> categorylist = categoryMapper.toCategoryDtos(categoryService.findAll());
		return ResponseEntity.ok(categorylist);
	}

}
