package com.stackroute.ng2boot.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
@JsonIgnoreProperties(ignoreUnknown=true)
public class Movie extends ResourceSupport {
	
	@Id
	private String imdbID;
	
	private String Title;
	
	private String Poster;
	
	private String Year;
	
	public Movie() {
		
	}
	@JsonCreator
	public Movie(@JsonProperty("imdbID")String imdbID, @JsonProperty("Title")String title, @JsonProperty("Poster")String poster, @JsonProperty("Year")String year){
		
		this.imdbID = imdbID;
		this.Title = title;
		this.Poster = poster;
		this.Year = year;
	}
	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}
	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}


	
}
