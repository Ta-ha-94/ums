package com.codingsy.ums.dto.user;

import com.codingsy.ums.dto.common.AddressDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
		
		@NotBlank(message = "Username is required")
		@Size(min = 4, max = 50, message = "Username must be between 4 to 50 characters.")
		String username,
		
		@NotBlank(message = "Email is required")
		@Size(max = 100, message = "Email must be less than 100 characters.")
		@Pattern(
			    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
			    message = "Email must be a valid format like user@example.com"
			)
		String email,
		
		@NotBlank(message = "Password is required")
		@Size(min = 8, message = "Password must be at least 8 characters long.")
		String password,
		
		@NotBlank(message = "First name is required")
		@Size(min = 1, max = 50, message = "First name must be between 1 to 50 characters.")
		String firstName,
		
		@NotBlank(message = "Last name is required")
		@Size(min = 1, max = 50, message = "Last name must be between 1 to 50 characters.")
		String lastName,
		
		@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits.")
		String phone,
		
		@Valid
		AddressDTO address
		
		) {
}
