package com.codingsy.ums.mapper;

import com.codingsy.ums.dto.common.AddressDTO;
import com.codingsy.ums.model.Address;

public class AddressMapper {

    public static Address mapDtoToEntity(AddressDTO dto) {
        if (dto == null) return null;

        return Address.builder()
                .street(dto.street())
                .city(dto.city())
                .state(dto.state())
                .pinCode(dto.pinCode())
                .country(dto.country())
                .build();
    }

    public static AddressDTO mapEntityToDto(Address address) {
        if (address == null) return null;

        return new AddressDTO(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPinCode(),
                address.getCountry()
        );
    }
}