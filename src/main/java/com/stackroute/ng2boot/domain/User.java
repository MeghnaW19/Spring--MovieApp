package com.stackroute.ng2boot.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {

	@Id
	private String UserID;
	private String Name;
	private int Age;
	private ArrayList<Movie> FavMovieList;	
	
	public User() {
	
	}
	
	@JsonCreator
	public User(@JsonProperty("UserID")String userID, @JsonProperty("Name")String name,@JsonProperty("Age") int age,@JsonProperty("FavMovieList") ArrayList<Movie> favMovieList) {
		UserID = userID;
		Name = name;
		Age = age;
		FavMovieList = favMovieList;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public ArrayList<Movie> getFavMovieList() {
		return FavMovieList;
	}

	public void setFavMovieList(ArrayList<Movie> favMovieList) {
		FavMovieList = favMovieList;
	}
	
	
	
	

}
