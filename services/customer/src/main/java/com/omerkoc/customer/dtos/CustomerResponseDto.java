package com.omerkoc.customer.dtos;

import java.time.LocalDateTime;

import com.omerkoc.customer.document.Address;

import lombok.Builder;

@Builder
public record CustomerResponseDto(String id, String tcNo, String name, String surname, LocalDateTime createdDate,
                LocalDateTime lastModifiedDate, String email, String phone, Address address) {

}
