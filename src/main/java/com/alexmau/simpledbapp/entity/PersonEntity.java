package com.alexmau.simpledbapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = PersonEntity.TABLE_NAME)
public class PersonEntity {

    protected static final String TABLE_NAME = "person";

    protected static final String ATTRIBUTE_PERSON_ID = "personId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = ATTRIBUTE_PERSON_ID,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addressList;
}
