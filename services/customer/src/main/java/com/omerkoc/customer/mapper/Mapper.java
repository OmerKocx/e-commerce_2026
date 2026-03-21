package com.omerkoc.customer.mapper;

import org.springframework.stereotype.Service;

import com.omerkoc.customer.document.Customer;
import com.omerkoc.customer.dtos.CustomerRequestDto;
import com.omerkoc.customer.dtos.CustomerResponseDto;

@Service
public class Mapper {
    public Customer toCustomer(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .name(customerRequestDto.name())
                .surname(customerRequestDto.surname())
                .email(customerRequestDto.email())
                .phone(customerRequestDto.phone())
                .address(customerRequestDto.address())
                .tcNo(customerRequestDto.tcNo())
                .build();
    }

    public CustomerResponseDto toCustomerResponseDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId().toString())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .tcNo(customer.getTcNo())
                .createdDate(customer.getCreatedDate())
                .lastModifiedDate(customer.getLastModifiedDate())
                .build();
    }
}
