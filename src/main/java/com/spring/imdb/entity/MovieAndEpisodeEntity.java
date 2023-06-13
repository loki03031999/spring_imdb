package com.spring.imdb.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movieandepisode")
public class MovieAndEpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieandepisode_id")
    public int movieAndEpisodeId;

    @ManyToOne
    @JoinColumn(name = "title_id")
    public TitleEntity titleEntity;

    public String name;
    public String description;

    @Column(name = "date_of_release", columnDefinition = "DATE")
    public Date dateOfRelease;

    public String language;

    @Column(name = "time_minutes")
    public int timeMinutes;

    @Column(name = "movieorseries")
    public String movieOrSeries;

    @Column(name = "episode_number")
    public int episodeNumber;

    @Column(name = "season_number")
    public int seasonNumber;

    @OneToMany(mappedBy = "person", targetEntity = MovieAndEpisode_PersonEntity.class)
    public Set<PersonEntity> personSet;

    public int getMovieandepisodeId() {
        return movieAndEpisodeId;
    }

    public void setMovieandepisodeId(int movieandepisodeId) {
        this.movieAndEpisodeId = movieandepisodeId;
    }

    public TitleEntity getTitleEntity() {
        return titleEntity;
    }

    public void setTitleEntity(TitleEntity titleEntity) {
        this.titleEntity = titleEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public String getMovieOrSeries() {
        return movieOrSeries;
    }

    public void setMovieOrSeries(String movieOrSeries) {
        this.movieOrSeries = movieOrSeries;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Set<PersonEntity> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<PersonEntity> personSet) {
        this.personSet = personSet;
    }

    @Override
    public String toString() {
        return "MovieAndEpisodeEntity [movieandepisodeId=" + movieAndEpisodeId + ", titleEntity=" + titleEntity
                + ", name=" + name + ", description=" + description + ", dateOfRelease=" + dateOfRelease + ", language="
                + language + ", timeMinutes=" + timeMinutes + ", movieOrSeries=" + movieOrSeries + ", episodeNumber="
                + episodeNumber + ", seasonNumber=" + seasonNumber + ", personSet=" + personSet + "]";
    }

}
