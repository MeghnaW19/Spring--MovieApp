package com.stackroute.ng2boot.controllers;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.service.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value="moviecruiser", description="Operations pertaining to the Movie Cruiser App")

@RestController
@RequestMapping("/v1/api/movie")
public class MovieRestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	MovieService movieService;
	

	
	
	@Autowired
	HeteoasLinkAssembler heteoasLinkAssembler;
	
	@ApiOperation(value = "View a list of available movies",response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
			)
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody  Iterable<Movie>  list() {
		logger.debug("Movie list");
		Iterable<Movie> allmovielist=movieService.listAllMovies();
		heteoasLinkAssembler.assembleLinks(allmovielist);
		return allmovielist;
	}

	
	@CrossOrigin(origins="http://localhost:4200")
	@ApiOperation(value = "Search a movie with an ID",response = Movie.class)
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Movie getMovie(@PathVariable String id, Model model){
		logger.debug("Search movier by ID");
		return movieService.getMovieById(id);
	}

	@ApiOperation(value = "Save a movie")
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity saveMovie(@RequestBody Movie movie){

		Movie saveMovie = movieService.saveMovie(movie);
		HttpHeaders headers =new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return new ResponseEntity<Movie>(saveMovie, headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a movie")
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity updateMovie(@PathVariable String id, @RequestBody Movie movie){
		movieService.updateMovie(id, movie);
		Map msgMap = new HashMap<String,String>();
		msgMap.put("message","Movie updated successsfully");
		return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);	}

	@ApiOperation(value = "Delete a movie")
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity deleteMovie(@PathVariable String id){
		movieService.deleteMovie(id);
		Map msgMap = new HashMap<String,String>();
		msgMap.put("message","Movie deleted successsfully");
		return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);
	}
}
