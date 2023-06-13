package com.spring.imdb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "movieandepisode_person")
@Data
public class MovieAndEpisode_PersonEntity {

    @EmbeddedId
    MovieAndEpisode_PersonKey id;

    @ManyToOne(targetEntity = MovieAndEpisodeEntity.class)
    @MapsId("movieAndEpisodeId")
    @JoinColumn(name = "movieandepisode_id")
    public MovieAndEpisodeEntity movieandepisode;

    @ManyToOne(targetEntity = PersonEntity.class)
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    public PersonEntity person;

    @Column(name = "name_in_movie")
    public String nameInMovie;

    @Column(name = "worked_as")
    public String workedAs;

}
