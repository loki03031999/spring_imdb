package com.spring.imdb.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="title")
public class TitleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="title_id")
	public int titleId;
	
	@Column(name="title")
	public String title;
	
	@ManyToMany
	@JoinTable(name="title_genre", joinColumns = @JoinColumn(name = "title_id"),inverseJoinColumns = @JoinColumn(name="genre_id"))
	public Set<GenreEntity> genreSet;
	
}
