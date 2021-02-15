package com.alexmau.simpledbapp.service;

import com.alexmau.simpledbapp.TestUtil;
import com.alexmau.simpledbapp.dao.PersonDAO;
import com.alexmau.simpledbapp.dto.Address;
import com.alexmau.simpledbapp.mapper.AddressMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private PersonDAO personDAO;

    @BeforeEach
    void createTestData() {
        personDAO.saveAll(List.of(TestUtil.PERSON_ENTITY_1, TestUtil.PERSON_ENTITY_2, TestUtil.PERSON_ENTITY_3));
    }

    @Test
    void shouldSaveAddress() throws Exception {
        int addressCountBefore = personDAO.findById(TestUtil.PERSON_ENTITY_1.getId()).get().getAddressList().size();
        Address expected = addressService.add(TestUtil.ADDRESS_4);
        int addressCountAfter = personDAO.findById(TestUtil.PERSON_ENTITY_1.getId()).get().getAddressList().size();
        Address actual = addressMapper.mapEntityToDto(personDAO
                .findById(TestUtil.PERSON_ENTITY_1.getId()).get().getAddressList().get(1));
        assertEquals(addressCountAfter, addressCountBefore+1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteAddress() throws Exception {
        addressService.delete(personDAO.findById(TestUtil.PERSON_ENTITY_3.getId()).get().getAddressList().get(0).getId());
        int expectedAddressListSize = personDAO.findById(TestUtil.PERSON_ENTITY_3.getId()).get().getAddressList().size();
        assertEquals(expectedAddressListSize, 0);
    }

    @Test
    void shouldUpdateAddress() throws Exception {
        addressService.update(personDAO.findById(TestUtil.PERSON_ENTITY_1.getId()).get().getAddressList().get(0).getId(),
                TestUtil.ADDRESS_4);
        Address expected = addressMapper.mapEntityToDto(personDAO
                .findById(TestUtil.PERSON_ENTITY_1.getId()).get().getAddressList().get(0));
        assertThat(expected).usingRecursiveComparison().ignoringFields("id").isEqualTo(TestUtil.ADDRESS_4);
    }
}
