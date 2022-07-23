package com.spring.imdb.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name="movieandepisode_person")
public class MovieAndEpisode_PersonEntity {

	@EmbeddedId
	MovieAndEpisode_PersonKey id;
	
	@ManyToOne
	@MapsId("movieandepisodeId")
	@JoinColumn(name = "movieandepisode_id")
	public MovieAndEpisodeEntity movieandepisode;
	
	@ManyToOne
	@MapsId("personId")
	@JoinColumn(name = "person_id")
	public PersonEntity person;
	
	@Column(name = "name_in_movie")
	public String nameInMovie;
	
	@Column(name = "worked_as")
	public String workedAs;
}
