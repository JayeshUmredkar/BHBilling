package com.brainhunter.bhbilling.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.brainhunter.bhbilling.dto.ProductDto;
import com.brainhunter.bhbilling.entity.Product;

@Mapper
public interface ProductMapper {

	ProductDto toProductDto(Product product);

	List<ProductDto> toProductDtos(List<Product> product);

	Product toProduct(ProductDto productDto);
}
