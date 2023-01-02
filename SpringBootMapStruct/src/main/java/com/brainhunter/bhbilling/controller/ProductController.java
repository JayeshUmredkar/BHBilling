package com.brainhunter.bhbilling.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainhunter.bhbilling.dto.CustomerDto;
import com.brainhunter.bhbilling.dto.ProductDto;
import com.brainhunter.bhbilling.entity.Product;
import com.brainhunter.bhbilling.mapper.ProductMapper;
import com.brainhunter.bhbilling.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired(required = false)
	private ProductService productService;

	@Autowired(required = false)
	private ProductMapper productMapper;

	@PostMapping("save")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
		System.out.println(productDto);
		Product product = productMapper.toProduct(productDto);
		System.out.println("productMapper = " + productMapper);
		System.out.println(product);
		System.out.println("productService = " + productService);
		productService.saveProduct(product);
		return ResponseEntity.ok(productDto);
	}

	@GetMapping("{id}")
	public ResponseEntity<ProductDto> findProductById(@PathVariable int id) {
		Optional<Product> product = productService.getProductById(id);
		ProductDto productDto = productMapper.toProductDto(product.get());
		return ResponseEntity.ok(productDto);
	}

	@GetMapping("getByName/{name}")
	public ResponseEntity<ProductDto> findProductByName(@PathVariable String name) {
		Optional<Product> product = productService.getProductByName(name);
		ProductDto productDto = productMapper.toProductDto(product.get());
		return ResponseEntity.ok(productDto);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable int id, @RequestBody ProductDto productDto) {
		Product product = productMapper.toProduct(productDto);
		product.setId(id);
		productService.updateProduct(product);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDto);
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		return productService.deleteProductById(id);
	}

	@GetMapping("getAll")
	public ResponseEntity<List<ProductDto>> findAll() {
		List<ProductDto> productlist = productMapper.toProductDtos(productService.findAll());
		return ResponseEntity.ok(productlist);
	}
}
