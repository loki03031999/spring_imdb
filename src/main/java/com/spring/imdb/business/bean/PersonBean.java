package com.spring.imdb.business.bean;

import java.util.Date;

public class PersonBean {
    public int personId;
    public String firstName;
    public String lastName;
    public String country;
    public Date dateOfBirth;
    public Date dateOfDeath;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public String toString() {
        return "PersonBean [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", country="
                + country + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + "]";
    }

}
