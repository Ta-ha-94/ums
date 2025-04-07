package com.codingsy.ums.dto.user;

import com.codingsy.ums.dto.common.AddressDTO;

import java.time.LocalDateTime;

public record UserAdminResponseDTO(
    Long id,
    String username,
    String email,
    String firstName,
    String lastName,
    String phone,
    boolean isActive,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    AddressDTO address
) {}