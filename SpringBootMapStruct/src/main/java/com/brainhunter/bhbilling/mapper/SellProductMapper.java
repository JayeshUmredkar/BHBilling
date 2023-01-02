package com.brainhunter.bhbilling.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.brainhunter.bhbilling.dto.SellProductDto;
import com.brainhunter.bhbilling.entity.SellProduct;

@Mapper
public interface SellProductMapper {

	SellProductDto toSellProductDto(SellProduct sellProduct);

	List<SellProductDto> toSellProductDtos(List<SellProduct> sellProducts);

	SellProduct toSellProduct(SellProductDto sellProductDto);

}
