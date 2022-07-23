package com.spring.imdb.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Person")
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="person_id")
	public int personId;
	
	@Column(name="first_name")
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column(name="date_of_birth",columnDefinition = "DATE")
	public Date dateOfBirth;
	
	@Column(name="date_of_death",columnDefinition = "DATE")
	public Date dateOfDeath;
	
	@Column(name="country")
	public String country;
	
	@OneToMany(mappedBy = "movieandepisode")
	public Set<MovieAndEpisodeEntity> movieAndEpisodeEntitySet; 
}
