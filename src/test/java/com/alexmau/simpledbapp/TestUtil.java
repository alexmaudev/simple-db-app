package com.alexmau.simpledbapp;

import com.alexmau.simpledbapp.dto.Address;
import com.alexmau.simpledbapp.dto.Person;
import com.alexmau.simpledbapp.entity.AddressEntity;
import com.alexmau.simpledbapp.entity.PersonEntity;

import java.util.List;

public final class TestUtil {

    private TestUtil() {
    }

    public static final AddressEntity ADDRESS_ENTITY_1 = new AddressEntity(1L, "1 Avenue", "New York",
            "New York", "120", 1L);
    public static final AddressEntity ADDRESS_ENTITY_2 = new AddressEntity(2L, "2 Avenue", "New York",
            "New York", "103", 2L);
    public static final AddressEntity ADDRESS_ENTITY_3 = new AddressEntity(3L, "3 Avenue", "New York",
            "New York", "114", 3L);

    public static final Address ADDRESS_4 = new Address(4L, "8 Avenue", "New York",
            "New York", "180", 1L);

    public static final PersonEntity PERSON_ENTITY_1 = new PersonEntity(1L, "John", "Best",
            List.of(ADDRESS_ENTITY_1));
    public static final PersonEntity PERSON_ENTITY_2 = new PersonEntity(2L, "Alex", "Morgan",
            List.of(ADDRESS_ENTITY_2));
    public static final PersonEntity PERSON_ENTITY_3 = new PersonEntity(3L, "Elisa", "Wood",
            List.of(ADDRESS_ENTITY_3));
    public static final Person PERSON_1 = new Person(4L, "Ann", "Brown",
            List.of(ADDRESS_ENTITY_3));
}
