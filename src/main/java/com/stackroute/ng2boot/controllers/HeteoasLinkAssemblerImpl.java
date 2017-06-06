package com.stackroute.ng2boot.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.stackroute.ng2boot.domain.Movie;

@Component
public class HeteoasLinkAssemblerImpl implements HeteoasLinkAssembler{
	
	public Iterable <Movie> assembleLinks(Iterable<Movie> allMovieList) {
		for(Movie movie2: allMovieList )	{
		Link selfLink= linkTo(MovieRestController.class).slash(movie2.getImdbID()).withSelfRel();
		movie2.add(selfLink);
		Link updateLink= linkTo(MovieRestController.class).slash(movie2.getImdbID()).withRel("Update");
		movie2.add(updateLink);
		Link deleteLink= linkTo(MovieRestController.class).slash(movie2.getImdbID()).withRel("Delete");
		movie2.add(deleteLink);
		}
		return allMovieList;
	}
}
