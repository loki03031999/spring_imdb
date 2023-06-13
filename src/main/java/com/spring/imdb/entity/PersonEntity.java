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

    @OneToMany(mappedBy = "movieandepisode", targetEntity = com.spring.imdb.entity.MovieAndEpisode_PersonEntity.class)
    public Set<MovieAndEpisodeEntity> movieAndEpisodeEntitySet;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<MovieAndEpisodeEntity> getMovieAndEpisodeEntitySet() {
        return movieAndEpisodeEntitySet;
    }

    public void setMovieAndEpisodeEntitySet(Set<MovieAndEpisodeEntity> movieAndEpisodeEntitySet) {
        this.movieAndEpisodeEntitySet = movieAndEpisodeEntitySet;
    }

    @Override
    public String toString() {
        return "PersonEntity [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + ", country=" + country
                + ", movieAndEpisodeEntitySet=" + movieAndEpisodeEntitySet + "]";
    }


}
