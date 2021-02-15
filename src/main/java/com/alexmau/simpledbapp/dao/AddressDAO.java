package com.alexmau.simpledbapp.dao;

import com.alexmau.simpledbapp.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<AddressEntity, Long> {
}
