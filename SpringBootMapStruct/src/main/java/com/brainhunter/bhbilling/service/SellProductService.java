package com.brainhunter.bhbilling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainhunter.bhbilling.entity.SellProduct;
import com.brainhunter.bhbilling.repository.SellProductRepository;

@Service
public class SellProductService {

	@Autowired(required = false)
	private SellProductRepository sellProductRepository;

	public List<SellProduct> saveSellProducts(List<SellProduct> sellProducts) {
		return sellProductRepository.saveAll(sellProducts);
	}

	public SellProduct saveSellProduct(SellProduct sellProduct) {
		return sellProductRepository.save(sellProduct);
	}

	public List<SellProduct> findAll() {
		return sellProductRepository.findAll();
	}

	public Optional<SellProduct> findSellProductById(int id) {
		return sellProductRepository.findById(id);
	}

	public String deleteSellProduct(int id) {
		sellProductRepository.deleteById(id);
		return "SellinProduct :- " + id + " has been removed!";
	}

	public SellProduct updateSellProduct(SellProduct sellProduct) {
		SellProduct existingSellProduct = sellProductRepository.findById(sellProduct.getId()).orElse(null);
		existingSellProduct.setQuantity(sellProduct.getQuantity());
		existingSellProduct.setSellingDiscount(sellProduct.getSellingDiscount());
		existingSellProduct.setSellingAt(sellProduct.getSellingAt());
		existingSellProduct.setCreatedAt(sellProduct.getCreatedAt());
		existingSellProduct.setUpdatedAt(sellProduct.getUpdatedAt());
		return sellProductRepository.save(existingSellProduct);
	}
}