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

	public MovieAndEpisode_PersonKey getId() {
		return id;
	}

	public void setId(MovieAndEpisode_PersonKey id) {
		this.id = id;
	}

	public MovieAndEpisodeEntity getMovieandepisode() {
		return movieandepisode;
	}

	public void setMovieandepisode(MovieAndEpisodeEntity movieandepisode) {
		this.movieandepisode = movieandepisode;
	}

	public PersonEntity getPerson() {
		return person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public String getNameInMovie() {
		return nameInMovie;
	}

	public void setNameInMovie(String nameInMovie) {
		this.nameInMovie = nameInMovie;
	}

	public String getWorkedAs() {
		return workedAs;
	}

	public void setWorkedAs(String workedAs) {
		this.workedAs = workedAs;
	}
	
	
}
