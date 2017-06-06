package com.stackroute.ng2boot.service;

import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.domain.User;

public interface UserService {
	
	public Iterable<User> userList();
	public User getUserByID(String id);
	public User addUser(User user);
	public void updateUser(String id, User user);
	public void deleteUser(String id);
	public Iterable<Movie> favMovieList(String id);
	public Movie addFavMovie(String id, Movie movie);
	public void deleteFavMovie(String id, Movie movie);
	

}
