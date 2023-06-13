package com.spring.imdb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class MovieAndEpisode_PersonKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "movieandepisode_id")
    int movieAndEpisodeId;

    @Column(name = "person_id")
    int personId;

}
