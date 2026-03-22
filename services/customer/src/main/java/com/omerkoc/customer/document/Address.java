package com.omerkoc.customer.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "addresses")
@Validated
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
