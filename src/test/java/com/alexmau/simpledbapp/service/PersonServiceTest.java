package com.alexmau.simpledbapp.service;

import com.alexmau.simpledbapp.TestUtil;
import com.alexmau.simpledbapp.dao.PersonDAO;
import com.alexmau.simpledbapp.dto.Person;
import com.alexmau.simpledbapp.mapper.PersonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonDAO personDAO;

    @BeforeEach
    void createTestData() {
        personDAO.saveAll(List.of(TestUtil.PERSON_ENTITY_1, TestUtil.PERSON_ENTITY_2, TestUtil.PERSON_ENTITY_3));
    }

    @Test
    void shouldDeletePerson() throws Exception {
        final Long countBefore = personService.count();
        personService.delete(TestUtil.PERSON_ENTITY_3.getId());
        final Long countAfter = personService.count();
        assertEquals( countAfter +1, countBefore);
    }

    @Test
    void shouldAddPerson() throws Exception {
        Person expected = personService.add(TestUtil.PERSON_1);
        assertEquals(TestUtil.PERSON_1, expected);
    }

    @Test
    void shouldUpdatePerson() throws Exception {
        Person updated = personService.update(TestUtil.PERSON_ENTITY_3.getId(), TestUtil.PERSON_1);
        assertEquals(TestUtil.PERSON_1.getFirstName(), updated.getFirstName());
        assertEquals(TestUtil.PERSON_1.getLastName(), updated.getLastName());
    }

    @Test
    void shouldGetPersonList() throws Exception {
        List<Person> personList = personService.getAll();
        assertEquals( List.of(TestUtil.PERSON_ENTITY_1,
                TestUtil.PERSON_ENTITY_2, TestUtil.PERSON_ENTITY_3)
                .stream().map(p -> personMapper.mapEntityToDto(p)).collect(Collectors.toList()), personList);
    }
}
