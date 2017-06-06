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
import com.stackroute.ng2boot.domain.User;
import com.stackroute.ng2boot.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/v1/api/user")
public class UserRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	private UserService userService;
	
	@Autowired
	public void setMovieService(UserService userService)
	{
		this.userService=userService;
	}
	

	@RequestMapping(value	=	"", method	=	RequestMethod.GET)
	public @ResponseBody  Iterable<User>  list() {
		
		logger.debug("User list");
		Iterable<User> allUsersList=userService.userList();
		return allUsersList ;
	}
	
	@RequestMapping(value	=	"{id}", method	=	RequestMethod.GET)
	public User getMovie(@PathVariable String id, Model model){
		
		logger.debug("Search User by ID");
		return userService.getUserByID(id);
	}
	
	@RequestMapping(value	=	"", method	=	RequestMethod.POST)
	public ResponseEntity addUser(@RequestBody User user){

		User adduser = userService.addUser(user);
		HttpHeaders headers =new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return new ResponseEntity<User>(adduser, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value	=	"{id}", method	=	RequestMethod.PUT)
	public ResponseEntity updateUser(@PathVariable String id, @RequestBody User user){
		userService.updateUser(id, user);
		Map msgMap = new HashMap<String,String>();
		msgMap.put("message","User updated successsfully");
		return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);	
		}
	
	@RequestMapping(value	=	"{id}", method=RequestMethod.DELETE)
	public ResponseEntity deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		Map msgMap = new HashMap<String,String>();
		msgMap.put("message","User deleted successsfully");
		return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);
	}

	@RequestMapping(value	=	"fav/{id}", method	=	RequestMethod.GET)
	public @ResponseBody  Iterable<Movie>  favMovieList(@PathVariable String id) {
		
		logger.debug("Fav movie list");
		Iterable<Movie> favMovieList=userService.favMovieList(id);
		return favMovieList  ;
	}
	
	@RequestMapping(value	=	"{id}", method=RequestMethod.POST)
	public ResponseEntity<Movie> addFavMovie(@PathVariable String id, @RequestBody Movie movie){
		Movie movies = userService.addFavMovie(id, movie);
		return new ResponseEntity<Movie>(movies, HttpStatus.OK);
	}
	
	@RequestMapping(value	=	"fav/{id}", method	=	RequestMethod.DELETE)
	public ResponseEntity<Map<String,String>> deleteFavMovie(@PathVariable String id, @RequestBody Movie movie){
		userService.deleteFavMovie(id, movie);
		Map msgMap = new HashMap<String,String>();
		msgMap.put("message","Movie deleted successsfully");
		return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);
	}

	

}
