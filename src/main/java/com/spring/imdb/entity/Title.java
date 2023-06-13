package com.spring.imdb.entity;

import com.spring.imdb.constants.DbConstants;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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
    public Set<DbConstants.Genre> genre;

    private String language;
    private String originCountry;
    private String releaseCountry;

}
