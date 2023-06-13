package com.spring.imdb.business.bean;

public class MovieAndEpisode_PersonBean {
    public int movieAndEpisodeId;
    public int personId;
    public String nameInMovie;
    public String workedAs;

    public int getMovieAndEpisodeId() {
        return movieAndEpisodeId;
    }

    public void setMovieAndEpisodeId(int movieAndEpisodeId) {
        this.movieAndEpisodeId = movieAndEpisodeId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getNameInMovie() {
        return nameInMovie;
    }

    public void setNameInMovie(String nameInMovie) {
        this.nameInMovie = nameInMovie;
    }

    public String getWorkedAs() {
        return workedAs;
    }

    public void setWorkedAs(String workedAs) {
        this.workedAs = workedAs;
    }
}
