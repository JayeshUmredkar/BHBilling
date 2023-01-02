package com.brainhunter.bhbilling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainhunter.bhbilling.entity.OrderDetail;
import com.brainhunter.bhbilling.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired(required = false)
	private OrderRepository orderRepository;

	public List<OrderDetail> saveOrders(List<OrderDetail> orderDetails) {
		return orderRepository.saveAll(orderDetails);
	}

	public OrderDetail saveOrder(OrderDetail orderDetail) {
		return orderRepository.save(orderDetail);
	}

	public List<OrderDetail> findAllOrder() {
		return orderRepository.findAll();
	}

	public Optional<OrderDetail> findOrderById(int id) {
		return orderRepository.findById(id);
	}

	public String deleteOrder(int id) {
		orderRepository.deleteById(id);
		return "Order Id:- " + id + "removed!!";
	}

	public OrderDetail updateOrder(OrderDetail orderDetail) {
		OrderDetail existingOrder = orderRepository.findById(orderDetail.getId()).orElse(null);
		existingOrder.setTotalAmount(orderDetail.getTotalAmount());
		existingOrder.setDiscountAmount(orderDetail.getDiscountAmount());
		existingOrder.setPayingAmount(orderDetail.getPayingAmount());
		existingOrder.setCgstPrice(orderDetail.getCgstPrice());
		existingOrder.setSgstPrice(orderDetail.getSgstPrice());
		existingOrder.setCreatedAt(orderDetail.getCreatedAt());
		existingOrder.setUpdatedAt(orderDetail.getUpdatedAt());
		return orderRepository.save(existingOrder);
	}
}
