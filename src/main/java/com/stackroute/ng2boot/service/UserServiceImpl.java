package com.stackroute.ng2boot.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.domain.User;
import com.stackroute.ng2boot.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> userList() {
		logger.debug("list all Users");
		return userRepository.findAll();
	}

	@Override
	public User getUserByID(String id) {
		logger.debug("Search user by id");
		return userRepository.findOne(id);	}

	@Override
	public User addUser(User user) {
		logger.debug("Adding a user");
		return userRepository.save(user);
	}

	@Override
	public void updateUser(String id, User user){
		logger.debug("Update a user");
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(String id){
		logger.debug("Delete a user");
		userRepository.delete(id);
	}

	@Override
	public Iterable<Movie> favMovieList(String id){
		logger.debug("Favourite Movie List");
		User user	=	userRepository.findOne(id);
		Iterable<Movie> movieList= user.getFavMovieList();
		return movieList;
	}

	@Override
	public Movie addFavMovie(String id, Movie movie){
		User user	=	userRepository.findOne(id);
		ArrayList<Movie> movieList= new ArrayList<Movie>();
		movieList.add(movie);
		user.setFavMovieList(movieList);
		userRepository.save(user);
		return movie;
	}

	@Override
	public void deleteFavMovie(String id, Movie movie){
		User user	=	userRepository.findOne(id);
		ArrayList<Movie> favMovieList	=	user.getFavMovieList();
		for(int i=0; i<favMovieList.size(); i++)
		{
			if(movie.getImdbID()	==	favMovieList.get(i).getImdbID()){
				favMovieList.remove(i);
			}
		}
		user.setFavMovieList(favMovieList);
		userRepository.save(user);
			
	}

}
