package com.spring.imdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "title")
@Data
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String titleName;

    @Column(name = "genre")
    private String genre;

    private String language;

    @Column(name = "origin_country")
    private String originCountry;

    @Column(name = "release_country")
    private String releaseCountry;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
}
