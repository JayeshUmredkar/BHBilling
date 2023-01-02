package com.brainhunter.bhbilling.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainhunter.bhbilling.dto.SellProductDto;
import com.brainhunter.bhbilling.entity.SellProduct;
import com.brainhunter.bhbilling.mapper.SellProductMapper;
import com.brainhunter.bhbilling.service.SellProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sellProduct")
public class SellProductController {
	
	@Autowired(required = false)
	private SellProductService sellProductService;
	
	@Autowired(required = false)
	private SellProductMapper sellProductMapper;
	
	
	@GetMapping("getAll")
	public ResponseEntity<List<SellProductDto>> findAll() {
		List<SellProductDto> sellProductList = sellProductMapper.toSellProductDtos(sellProductService.findAll());
		return ResponseEntity.ok(sellProductList);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SellProductDto> findProductById(@PathVariable int id) {
		Optional<SellProduct> product = sellProductService.findSellProductById(id);
		SellProductDto sellProductDto = sellProductMapper.toSellProductDto(product.get());
		return ResponseEntity.ok(sellProductDto);
	}
}
