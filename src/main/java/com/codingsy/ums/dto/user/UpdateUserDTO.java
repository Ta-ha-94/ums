package com.codingsy.ums.dto.user;

import com.codingsy.ums.dto.common.AddressDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateUserDTO(

    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters")
    String username,

    @Size(max = 100, message = "Email must be less than 100 characters")
    String email,

    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password,

    @Size(max = 50, message = "First name must be less than 50 characters")
    String firstName,

    @Size(max = 50, message = "Last name must be less than 50 characters")
    String lastName,

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    String phone,

    @Valid
    AddressDTO address

) {}
