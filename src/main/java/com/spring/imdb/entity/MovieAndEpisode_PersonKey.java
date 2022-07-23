package com.spring.imdb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovieAndEpisode_PersonKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "movieandepisode_id")
	int movieAndEpisodeId;
	
	@Column(name = "movieandepisode_id")
	int personId;

}
