package com.spring.imdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "title")
@Data
public class TitleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "title_id")
    public int titleId;

    @Column(name = "title")
    public String titleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "title_genre", joinColumns = @JoinColumn(name = "title_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    public Set<GenreEntity> genreSet;

}
