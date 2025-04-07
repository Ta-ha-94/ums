package com.codingsy.ums.mapper;

import com.codingsy.ums.dto.user.CreateUserDTO;
import com.codingsy.ums.dto.user.UpdateUserDTO;
import com.codingsy.ums.dto.user.UserAdminResponseDTO;
import com.codingsy.ums.dto.user.UserProfileDTO;
import com.codingsy.ums.model.User;

import java.time.LocalDateTime;

public class UserMapper {

    public static User toUser(CreateUserDTO dto) {
        return User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .phone(dto.phone())
                .address(AddressMapper.mapDtoToEntity(dto.address()))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isActive(true)
                .build();
    }

    public static User updateUserFromDto(UpdateUserDTO dto, User existingUser) {
    	if (dto == null || existingUser == null) return existingUser;

    	return existingUser.toBuilder()
    	        .username(dto.username() != null ? dto.username() : existingUser.getUsername())
    	        .email(dto.email() != null ? dto.email() : existingUser.getEmail())
    	        .password(dto.password() != null ? dto.password() : existingUser.getPassword())
    	        .firstName(dto.firstName() != null ? dto.firstName() : existingUser.getFirstName())
    	        .lastName(dto.lastName() != null ? dto.lastName() : existingUser.getLastName())
    	        .phone(dto.phone() != null ? dto.phone() : existingUser.getPhone())
    	        .address(dto.address() != null
    	            ? AddressMapper.mapDtoToEntity(dto.address())
    	            : existingUser.getAddress())
    	        .updatedAt(LocalDateTime.now())
    	        .build();
    }

    public static UserProfileDTO toUserProfileDTO(User user) {
        return new UserProfileDTO(
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                AddressMapper.mapEntityToDto(user.getAddress())
        );
    }

    public static UserAdminResponseDTO toUserAdminResponseDTO(User user) {
        return new UserAdminResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.isActive(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                AddressMapper.mapEntityToDto(user.getAddress())
        );
    }
}
