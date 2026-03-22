package com.omerkoc.customer.dtos;

import com.omerkoc.customer.document.Address;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CustomerRequestDto(
                @NotBlank(message = "Name is required") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name,

                @NotBlank(message = "Surname is required") @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters") String surname,

                @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email,

                @NotBlank(message = "Phone is required") @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Phone number should be valid") String phone,

                @NotNull(message = "Address is required") @Valid Address address,

                @NotBlank(message = "TC No is required") @Pattern(regexp = "[0-9]{11}", message = "TC No must be 11 digits") String tcNo

) {
}
