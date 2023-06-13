package com.spring.imdb.entity;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "person_id")
    public int id;

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
        return "PersonEntity [personId=" + id + ", firstName=" + firstName + ", lastName=" + lastName
                + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + ", country=" + country
                + "]";
    }

}
