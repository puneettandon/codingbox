package com.systemdesign.movieticketbooking.api;

import com.systemdesign.movieticketbooking.model.Movie;
import com.systemdesign.movieticketbooking.services.MovieService;

public class MovieController {

    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String createMovie(final String movieName){
        return movieService.createMovie(movieName).getId();
    }
}
