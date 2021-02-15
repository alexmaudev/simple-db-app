package com.alexmau.simpledbapp.mapper;

import com.alexmau.simpledbapp.dto.Person;
import com.alexmau.simpledbapp.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",   unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    Person mapEntityToDto(PersonEntity personEntity);

    PersonEntity mapDtoToEntity(Person person);
}
