package com.stackroute.ng2boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.repositories.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MovieRepository movieRepository;

	public Iterable<Movie> listAllMovies() {
		logger.debug("list all movies");
		return movieRepository.findAll();
		
//		ArrayList<Movie> movieList = new ArrayList<Movie>();
//		ObjectMapper mapper = new ObjectMapper();
//		File file	=	new File("./src/main/resources/json/movie.json");
//		try {
//			Movie movie[]=mapper.readValue(file, Movie[].class);
//			for(Movie movie2:movie){
//				movieList.add(movie2);
//			}
//		} 
//		catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return movieList ;
	}

	public Movie getMovieById(String id) {
		logger.debug("Search movie by id");
		return movieRepository.findOne(id);
//		List<Movie> movieList = listAllMovies();
//		Movie movie = null;
//		
//		for(Movie moviee : movieList){
//			if(moviee.getImdbID().equals(id)){
//				movie = moviee;
//				break;
//			}
//		}
		
		
	}

	public void deleteMovie(String id) {
		logger.debug("delete movie by id");
		movieRepository.delete(id);

		
	}

	public Movie saveMovie(Movie movie1) {
		movieRepository.save(movie1);
		return movie1;
	}

	
	public void updateMovie(String id, Movie movie) {
		movieRepository.save(movie);
	}

}
