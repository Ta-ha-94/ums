package com.codingsy.ums.dto.common;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressDTO(
		
		@NotBlank(message = "Street is required")
		@Size(max = 255, message = "Street must be less than 255 characters.")
		String street,
		
		@NotBlank(message = "City is required")
		@Size(max = 100, message = "City must be less than 100 characters.")
		String city,
		
		@NotBlank(message = "State is required")
		@Size(max = 100, message = "State must be less than 100 characters.")
		String state,
		
		@Column(name = "pin_code")
		@NotBlank(message = "Pin code is required")
		@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pin code must be a valid 6-digit number")
		String pinCode,
		
		@NotBlank(message = "Country is required")
		@Size(max = 100, message = "Country must be less than 100 characters.")
		String country
		
		) {

}
