package com.spring.imdb.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Genre")
public class GenreEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="genre_id")
	public int genreId;
	
	@Column(name="genre_name")
	public String genreName;
	
	@ManyToMany(mappedBy = "genreSet")
	public Set<TitleEntity> titleSet;
}
