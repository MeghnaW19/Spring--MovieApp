package com.stackroute.ng2boot.service;

import com.stackroute.ng2boot.domain.Movie;

public interface MovieService{
	
	public Iterable<Movie> listAllMovies();
	public Movie getMovieById(String imdbID);
	public void deleteMovie(String imdbbID);
	public Movie saveMovie(Movie movie1);
	public void updateMovie(String id, Movie movie);
}
