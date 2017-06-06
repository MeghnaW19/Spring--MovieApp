package com.stackroute.ng2boot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.ng2boot.domain.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {};
