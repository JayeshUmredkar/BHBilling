package com.brainhunter.bhbilling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainhunter.bhbilling.entity.Customer;
import com.brainhunter.bhbilling.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired(required = false)
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer saveCustomer(Customer customer) {
		if (customerRepository.findByMobileNumber(customer.getMobileNumber()).isPresent()) {
			System.out.println("Customer MobileNumber with " + customer.getName() + " is already exist !!"); 
		}

		return customerRepository.save(customer);
		
	}

	public Optional<Customer> getCustomerById(int id) {
		return customerRepository.findById(id);
	}

	public Optional<Customer> getCustomerByMobileNumber(String mobileNumber) {
		return customerRepository.findByMobileNumber(mobileNumber);
	}

	public Optional<Customer> getCustomerByEmail(String email) {
		return customerRepository.findByemail(email);
	}

	public Optional<Customer> getCustomerByName(String name) {
		return customerRepository.findByname(name);
	}

	public String deleteCustomerById(int id) {
		customerRepository.deleteById(id);
		return "Customer removed ! Id:- " + id;
	}

	public String updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
		existingCustomer.setName(customer.getName());
		existingCustomer.setMobileNumber(customer.getMobileNumber());
		existingCustomer.setActionComment(customer.getActionComment());
		existingCustomer.setCreatedAt(customer.getCreatedAt());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setUpdatedAt(customer.getUpdatedAt());
		existingCustomer.setEmail(customer.getEmail());
		 customerRepository.save(existingCustomer);
		 return "Customer Updated successfully !";
	}

}
