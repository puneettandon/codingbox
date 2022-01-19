package com.systemdesign.movieticketbooking.api;

import com.systemdesign.movieticketbooking.model.Movie;
import com.systemdesign.movieticketbooking.model.Screen;
import com.systemdesign.movieticketbooking.model.Seat;
import com.systemdesign.movieticketbooking.model.Show;
import com.systemdesign.movieticketbooking.services.MovieService;
import com.systemdesign.movieticketbooking.services.SeatAvailabilityService;
import com.systemdesign.movieticketbooking.services.ShowService;
import com.systemdesign.movieticketbooking.services.TheatreService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {

    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public ShowController(SeatAvailabilityService seatAvailabilityService, ShowService showService, TheatreService theatreService, MovieService movieService) {
        this.seatAvailabilityService = seatAvailabilityService;
        this.showService = showService;
        this.theatreService = theatreService;
        this.movieService = movieService;
    }

    public String createShow(final String movieId, final String screenId,final  Date startTime,final Integer durationInSeconds){
        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie,screen,startTime,durationInSeconds).getId();
    }

    public List<String> getAvailableSeats(final String showId){
        final Show show = showService.getShow(showId);
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return  availableSeats.stream().map(Seat:: getId).collect(Collectors.toList());
    }

}
