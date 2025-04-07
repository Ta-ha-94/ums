package com.codingsy.ums.dto.user;

import com.codingsy.ums.dto.common.AddressDTO;

public record UserProfileDTO(
    String username,
    String email,
    String firstName,
    String lastName,
    String phone,
    AddressDTO address
) {}