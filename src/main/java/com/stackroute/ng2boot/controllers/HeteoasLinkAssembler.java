package com.stackroute.ng2boot.controllers;

import java.util.List;

import com.stackroute.ng2boot.domain.Movie;

public interface HeteoasLinkAssembler {
  public Iterable<Movie> assembleLinks(Iterable<Movie> allmovielist);
}
