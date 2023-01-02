package com.brainhunter.bhbilling.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.brainhunter.bhbilling.dto.CategoryDto;
import com.brainhunter.bhbilling.entity.Category;

@Mapper
public interface CategoryMapper {

	CategoryDto toCategoryDto(Category category);

	List<CategoryDto> toCategoryDtos(List<Category> categorys);

	Category toCategory(CategoryDto categoryDto);

}
