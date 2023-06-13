package com.spring.imdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Genre")
@Data
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    public int genreId;

    @Column(name = "genre_name")
    public String genreName;

    @ManyToMany(mappedBy = "genreSet")
    public Set<TitleEntity> titleSet;

    public String toString() {
        return genreId + genreName;
    }

}
