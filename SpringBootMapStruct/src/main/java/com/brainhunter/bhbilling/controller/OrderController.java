package com.brainhunter.bhbilling.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainhunter.bhbilling.dto.OrderDetailDto;
import com.brainhunter.bhbilling.entity.OrderDetail;
import com.brainhunter.bhbilling.mapper.OrderMapper;
import com.brainhunter.bhbilling.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired(required = false)
	private OrderService orderService;
	
	@Autowired(required = false)
	private OrderMapper orderMapper;
	
	@PostMapping("save")
	public ResponseEntity<OrderDetailDto> creatOrder(@RequestBody OrderDetailDto orderDetailDto){
		System.out.println(orderDetailDto);
		OrderDetail orderDetail = orderMapper.toOrderDetail(orderDetailDto);
		System.out.println("orderMapper= " + orderMapper);
		System.out.println(orderDetail);
		System.out.println("orderService= " + orderService);
		orderService.saveOrder(orderDetail);
		return ResponseEntity.ok(orderDetailDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<OrderDetailDto> findOrderById(@PathVariable int id){
		Optional<OrderDetail> orderDetail= orderService.findOrderById(id);
		OrderDetailDto orderDetailDto = orderMapper.toOrderDetailDto(orderDetail.get());
		return ResponseEntity.ok(orderDetailDto);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<OrderDetailDto>> findAll() {
		List<OrderDetailDto> orderList = orderMapper.toOrderDetailDtos(orderService.findAllOrder());
		return ResponseEntity.ok(orderList);
	}
}
