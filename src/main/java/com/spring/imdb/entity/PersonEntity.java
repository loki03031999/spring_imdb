package com.spring.imdb.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    public int personId;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    public Date dateOfBirth;

    @Column(name = "date_of_death", columnDefinition = "DATE")
    public Date dateOfDeath;

    @Column(name = "country")
    public String country;

    @Override
    public String toString() {
        return "PersonEntity [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + ", country=" + country
                + "]";
    }


}
