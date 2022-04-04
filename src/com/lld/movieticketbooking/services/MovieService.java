package com.lld.movieticketbooking.services;

import com.lld.cache.exceptions.NotFoundException;
import com.lld.movieticketbooking.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {

    private final Map<String , Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public Movie getMovie(final String movieId){
        if(!movies.containsKey(movieId)){
            throw new NotFoundException();
        }
        return movies.get(movieId);
    }

    public Movie createMovie(final String movieName){
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId,movieName);
        movies.put(movieId,movie);
        return movie;
    }
}
