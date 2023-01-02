package com.brainhunter.bhbilling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainhunter.bhbilling.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByname(String name);

	Optional<Customer> findByMobileNumber(String mobileNumber);

	Optional<Customer> findByemail(String email);

}
