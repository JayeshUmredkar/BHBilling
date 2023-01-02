package com.brainhunter.bhbilling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainhunter.bhbilling.entity.SellProduct;

@Repository
public interface SellProductRepository extends JpaRepository<SellProduct, Integer> {

}
