package com.brainhunter.bhbilling.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainhunter.bhbilling.dto.CustomerDto;
import com.brainhunter.bhbilling.entity.Customer;
import com.brainhunter.bhbilling.mapper.CustomerMapper;
import com.brainhunter.bhbilling.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired(required = false)
	private CustomerService customerService;

	@Autowired(required = false)
	private CustomerMapper customerMapper;

	@PostMapping("save")
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
		System.out.println(customerDto);
		Customer customer = customerMapper.toCustomer(customerDto);
		System.out.println("customerMapper = " + customerMapper);
		System.out.println(customer);
		System.out.println("customerService = " + customerService);
		customerService.saveCustomer(customer);
		return ResponseEntity.ok(customerDto);
	}

	@GetMapping("getById/{id}")
	public ResponseEntity<CustomerDto> findCustomerById(@PathVariable int id) {
		Optional<Customer> customer = customerService.getCustomerById(id);
		CustomerDto customerDto = customerMapper.toCustomerDto(customer.get());
		return ResponseEntity.ok(customerDto);

	}

	@GetMapping("getByMobileNumber/{mobileNumber}")
	public ResponseEntity<CustomerDto> findCustomerByMobileNumber(@PathVariable String mobileNumber) {
		Optional<Customer> customer = customerService.getCustomerByMobileNumber(mobileNumber);
		CustomerDto customerDto = customerMapper.toCustomerDto(customer.get());
		return ResponseEntity.ok(customerDto);
	}

	@GetMapping("getByEmail/{email}")
	public ResponseEntity<CustomerDto> findCustomerByEmail(@PathVariable String email) {
		Optional<Customer> customer = customerService.getCustomerByEmail(email);
		CustomerDto customerDto = customerMapper.toCustomerDto(customer.get());
		return ResponseEntity.ok(customerDto);

	}

	@GetMapping("getByName/{name}")
	public ResponseEntity<CustomerDto> findCustomerByName(@PathVariable String name) {
		Optional<Customer> customer = customerService.getCustomerByName(name);
		CustomerDto customerDto = customerMapper.toCustomerDto(customer.get());
		return ResponseEntity.ok(customerDto);

	}

	@PutMapping("update/{id}")
	public ResponseEntity<CustomerDto> update(@PathVariable int id, @RequestBody CustomerDto customerDto) {
		Customer customer = customerMapper.toCustomer(customerDto);
		customer.setId(id);
		customerService.updateCustomer(customer);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDto);
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		return customerService.deleteCustomerById(id);
	}

	@GetMapping("getAll")
	public ResponseEntity<List<CustomerDto>> findAll() {
		List<CustomerDto> customerlist = customerMapper.toCustomerDtos(customerService.findAll());
		return ResponseEntity.ok(customerlist);
	}
}