package com.brainhunter.bhbilling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainhunter.bhbilling.entity.OrderDetail;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Integer> {

}
