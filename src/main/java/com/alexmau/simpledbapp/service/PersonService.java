package com.alexmau.simpledbapp.service;

import com.alexmau.simpledbapp.dao.PersonDAO;
import com.alexmau.simpledbapp.dto.Person;
import com.alexmau.simpledbapp.entity.PersonEntity;
import com.alexmau.simpledbapp.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@Transactional
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonDAO personDAO;

    public Person add(Person person) {
        return personMapper
                .mapEntityToDto(
                        personDAO.save(personMapper.mapDtoToEntity(person)));
    }

    public Person update(Long id, Person person) {
        Optional<PersonEntity> optional = personDAO.findById(id);
        if (optional.isPresent()) {
            PersonEntity entity = optional.get();
            entity.setFirstName(person.getFirstName() == null ?entity.getFirstName():person.getFirstName());
            entity.setLastName(person.getLastName() == null ?entity.getLastName():person.getLastName());
            return personMapper.mapEntityToDto(personDAO.save(entity));
        } else {
            return new Person();
        }
    }

    public void delete(Long id) {
        personDAO.deleteById(id);
    }

    public long count() {
        return personDAO.count();
    }

    public List<Person> getAll() {
        return personDAO
                .findAll()
                .stream().map(p -> personMapper.mapEntityToDto(p)).collect(Collectors.toList());
    }
}
