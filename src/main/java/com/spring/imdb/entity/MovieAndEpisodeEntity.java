package com.spring.imdb.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "movieandepisode")
public class MovieAndEpisodeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieandepisode_id")
	public int movieandepisodeId;
	
	@ManyToOne
	@JoinColumn(name="title_id")
	public TitleEntity titleEntity;
	
	
	public String name;
	public String description;
	
	@Column(name="date_of_release",columnDefinition = "DATE")
	public Date dateOfRelease;
	
	public String language;
	
	@Column(name="time_minutes")
	public int timeMinutes;
	
	@Column(name="movieorseries")
	public String movieOrSeries;
	@Column(name="episode_number")
	public int episodeNumber;
	@Column(name="season_number")
	public int seasonNumber;
	
	@OneToMany(mappedBy = "person")
	public Set<PersonEntity> personSet;
	
}
