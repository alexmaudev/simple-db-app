package com.alexmau.simpledbapp.dao;

import com.alexmau.simpledbapp.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<PersonEntity, Long> {

    @Override
    List<PersonEntity> findAll();
}
