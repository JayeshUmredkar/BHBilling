package com.brainhunter.bhbilling.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.brainhunter.bhbilling.dto.CustomerDto;
import com.brainhunter.bhbilling.entity.Customer;

@Mapper
public interface CustomerMapper {

	CustomerDto toCustomerDto(Customer customer);

	List<CustomerDto> toCustomerDtos(List<Customer> customers);

	Customer toCustomer(CustomerDto customerDto);

}
