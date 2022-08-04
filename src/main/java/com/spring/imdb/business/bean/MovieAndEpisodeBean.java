package com.spring.imdb.business.bean;

import java.util.Date;

public class MovieAndEpisodeBean {
	public int movieAndEpisodeId;
	public int titleId;
	public String name;
	public String description;
	public Date dateOfRelease;
	public String language;
	public int timeMinutes;
	public String movieOrSeries;
	public int episodeNumber;
	public int seasonNumber;
	
	public int getMovieEpisodeId() {
		return movieAndEpisodeId;
	}
	public void setMovieEpisodeId(int movieEpisodeId) {
		this.movieAndEpisodeId = movieEpisodeId;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
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
	public String getLanguages() {
		return language;
	}
	public void setLanguages(String languages) {
		this.language = languages;
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
	@Override
	public String toString() {
		return "MovieAndEpisodeBean [movieEpisodeId=" + movieAndEpisodeId + ", titleId=" + titleId + ", name=" + name
				+ ", description=" + description + ", dateOfRelease=" + dateOfRelease + ", language=" + language
				+ ", timeMinutes=" + timeMinutes + ", movieOrSeries=" + movieOrSeries + ", episodeNumber="
				+ episodeNumber + ", seasonNumber=" + seasonNumber + "]";
	}
	
	
	
}
