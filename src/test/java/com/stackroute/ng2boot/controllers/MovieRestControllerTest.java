package com.stackroute.ng2boot.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = MovieRestController.class)

public class MovieRestControllerTest {
//	private MockMvc mockMvc;
//
//
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//	@MockBean
//	private MovieService movieService;
//	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//	@Before
//	public void setUp() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//
//	@Test
//	public void list() throws Exception {
//		Movie movie1 = new Movie();
//		movie1.setImdbID("imdb1");
//		movie1.setTitle("Meter");
//		movie1.setPoster("meter.jpg");
//		movie1.setYear("2015");
//
//		Movie movie2 = new Movie();
//		movie2.setImdbID("imdb2");
//		movie2.setTitle("Gladiator");
//		movie2.setPoster("gladiator.jpg");
//		movie2.setYear("2010");
//		List<Movie> movies = Arrays.asList(
//				movie1,movie2);
//		when(movieService.listAllMovies()).thenReturn(movies);
//		mockMvc.perform(get("/v1/api/movie"))
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//		.andExpect(jsonPath("$", hasSize(2)))
//		.andExpect(jsonPath("$[0].imdbID", is("imdb1")))
//		.andExpect(jsonPath("$[0].Title", is("Meter")))
//		.andExpect(jsonPath("$[1].Poster", is("gladiator.jpg")))
//		.andExpect(jsonPath("$[1].Year", is("2010")));
//		verify(movieService, times(1)).listAllMovies();
//		verifyNoMoreInteractions(movieService);
//
//	}
//
//
//	@Test
//	public void getMovie() throws Exception {
//		Movie movie = new Movie();
//		movie.setImdbID("imdb1");
//		movie.setTitle("Meter");
//		movie.setPoster("meter.jpg");
//		movie.setYear("2015");
//		String expectedJsonResponse="{\n" +
//				"  \"imdbID\": \"imdb1\",\n" +
//				"  \"Title\": \"Meter\",\n" +
//				"  \"Year\": \"2015\",\n" +
//				"  \"Poster\": \"meter.jpg\"\n" +
//				"}";
//		when(movieService.getMovieById("imdb1")).thenReturn(movie);
//		mockMvc.perform(get("/v1/api/movie/imdb1"))
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//		.andExpect(content().json(expectedJsonResponse));
//		verify(movieService, times(1)).getMovieById("imdb1");
//		verifyNoMoreInteractions(movieService);
//	}
//
////	@Test
////	public void saveMovie() throws Exception {
////		Movie movie1 = new Movie();
////		movie1.setImdbID("imdb1");
////		movie1.setTitle("Meter");
////		movie1.setYear("2015");
////		movie1.setPoster("meter.jpg");
////		when(movieService.saveMovie(movie1)).thenReturn(movie1);
////		mockMvc.perform(post("/v1/api/movie")
////				.contentType(MediaType.APPLICATION_JSON_UTF8)
////				.content(asJsonString(movie1))
////				.accept(MediaType.APPLICATION_JSON))
////		.andExpect(status().isOk())
////		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
////
////		verify(movieService, times(1)).saveMovie(movie1);
////		verifyNoMoreInteractions(movieService);
////	}
//
//	@Test
//	public void deleteMovie() throws Exception {
//		String expectedJsonResponse="{\n" +
//				"  \"message\": \"Movie deleted successsfully\"\n" +
//				"}";
//
//		doNothing().when(movieService).deleteMovie("imdb1");
//		mockMvc.perform(delete("/v1/api/movie/imdb1")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//		.andExpect(content().json(expectedJsonResponse));
//		verify(movieService, times(1)).deleteMovie("imdb1");
//		verifyNoMoreInteractions(movieService);
//	}
//
//	public static String asJsonString(final Object obj) {
//		try {
//			final ObjectMapper mapper = new ObjectMapper();
//			final String jsonContent = mapper.writeValueAsString(obj);
//			System.out.println(jsonContent);
//			return jsonContent;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	
	@Test
public void deleteMovie() throws Exception {
	
	}
}