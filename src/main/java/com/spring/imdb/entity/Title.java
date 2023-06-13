package com.spring.imdb.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "title")
@Data
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "title_id")
    public int id;

    @Column(name = "title")
    public String titleName;

    @Column(name = "genre")
    public String genre;

    private String language;
    private String originCountry;
    private String releaseCountry;

}
