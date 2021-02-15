package com.alexmau.simpledbapp.mapper;

import com.alexmau.simpledbapp.dto.Address;
import com.alexmau.simpledbapp.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",   unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    Address mapEntityToDto(AddressEntity addressEntity);

    AddressEntity mapDtoToEntity(Address address);
}
