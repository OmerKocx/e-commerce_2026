package com.omerkoc.customer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omerkoc.customer.document.Customer;
import com.omerkoc.customer.dtos.CustomerRequestDto;
import com.omerkoc.customer.dtos.CustomerResponseDto;
import com.omerkoc.customer.exception.CustomerNotFoundException;
import com.omerkoc.customer.mapper.Mapper;
import com.omerkoc.customer.repository.CustomerRepository;
import com.omerkoc.customer.service.ICustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final Mapper mapper;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = mapper.toCustomer(customerRequestDto);
        Customer savedCustomer = customerRepository.save(customer);
        return mapper.toCustomerResponseDto(savedCustomer);
    }

    @Override
    public CustomerResponseDto updateCustomer(String id, CustomerRequestDto customerRequestDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customer.setName(customerRequestDto.name());
        customer.setSurname(customerRequestDto.surname());
        customer.setEmail(customerRequestDto.email());
        customer.setPhone(customerRequestDto.phone());
        customer.setAddress(customerRequestDto.address());
        customer.setTcNo(customerRequestDto.tcNo());
        Customer savedCustomer = customerRepository.save(customer);
        return mapper.toCustomerResponseDto(savedCustomer);
    }

    @Override
    public CustomerResponseDto getCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        return mapper.toCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto getCustomerByTcNo(String tcNo) {
        Customer customer = customerRepository.findByTcNo(tcNo)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        return mapper.toCustomerResponseDto(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Cannot delete. Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(mapper::toCustomerResponseDto).toList();
    }

}
