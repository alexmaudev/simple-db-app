package com.alexmau.simpledbapp.service;

import com.alexmau.simpledbapp.dao.AddressDAO;
import com.alexmau.simpledbapp.dto.Address;
import com.alexmau.simpledbapp.entity.AddressEntity;
import com.alexmau.simpledbapp.mapper.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressDAO addressDAO;

    public Address add(Address address) {
        return addressMapper
                .mapEntityToDto(
                        addressDAO.save(addressMapper.mapDtoToEntity(address)));
    }

    public void update(Long id, Address address) {
        Optional<AddressEntity> optional = addressDAO.findById(id);
        if (optional.isPresent()) {
        AddressEntity entity = optional.get();
            if (entity.getPersonId()
                    .equals(address.getPersonId())) {
                entity.setStreet(address.getStreet() == null ?entity.getStreet():address.getStreet());
                entity.setCity(address.getCity() == null ?entity.getCity():address.getCity());
                entity.setState(address.getState() == null ?entity.getState():address.getState());
                entity.setPostalCode(address.getPostalCode() == null ?entity.getPostalCode():address.getPostalCode());
                addressDAO.save(entity);
            }
        }
    }

    public void delete(Long id) {
            addressDAO.deleteById(id);
    }
}
