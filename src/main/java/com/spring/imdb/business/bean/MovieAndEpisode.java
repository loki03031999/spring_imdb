package com.spring.imdb.business.bean;

import java.util.Date;

public class MovieAndEpisode {
	public int movieEpisodeId;
	public TitleBean titleId;
	public String name;
	public String description;
	public Date dateOfRelease;
	public String languages;
	public int timeMinutes;
	public String movieOrSeries;
	public int episodeNumber;
	public int seasonNumber;
	
	public int getMovieEpisodeId() {
		return movieEpisodeId;
	}
	public void setMovieEpisodeId(int movieEpisodeId) {
		this.movieEpisodeId = movieEpisodeId;
	}
	public TitleBean getTitleId() {
		return titleId;
	}
	public void setTitleId(TitleBean titleId) {
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
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
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
	
	
}
