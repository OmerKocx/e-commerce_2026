package com.omerkoc.customer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.omerkoc.customer.dtos.CustomerRequestDto;
import com.omerkoc.customer.dtos.CustomerResponseDto;

public interface ICustomerController {
    ResponseEntity<CustomerResponseDto> createCustomer(CustomerRequestDto customerRequestDto);

    ResponseEntity<CustomerResponseDto> updateCustomer(String id, CustomerRequestDto customerRequestDto);

    ResponseEntity<CustomerResponseDto> getCustomerById(String id);

    ResponseEntity<CustomerResponseDto> getCustomerByTcNo(String tcNo);

    ResponseEntity<Void> deleteCustomer(String id);

    ResponseEntity<List<CustomerResponseDto>> getAllCustomers();
}
