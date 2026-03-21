package com.omerkoc.customer.service;

import java.util.List;

import com.omerkoc.customer.dtos.CustomerRequestDto;
import com.omerkoc.customer.dtos.CustomerResponseDto;

public interface ICustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto updateCustomer(String id, CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomerById(String id);

    CustomerResponseDto getCustomerByTcNo(String tcNo);

    void deleteCustomer(String id);

    List<CustomerResponseDto> getAllCustomers();
}
