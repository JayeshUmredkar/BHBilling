package com.brainhunter.bhbilling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainhunter.bhbilling.entity.Product;
import com.brainhunter.bhbilling.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired(required = false)
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		System.out.println("Product :- " + product.getName() + " added successfully!!");
		return productRepository.save(product);
	}

	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}

	public Optional<Product> getProductByName(String name) {
		return productRepository.findByName(name);
	}

	public String deleteProductById(int id) {
		productRepository.deleteById(id);
		return "Product removed ! Id:- " + id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setMrp(product.getMrp());
		existingProduct.setSellingPrice(product.getSellingPrice());
		existingProduct.setCreatedAt(product.getCreatedAt());
		existingProduct.setUpdatedAt(product.getUpdatedAt());
		return productRepository.save(existingProduct);
	}
}