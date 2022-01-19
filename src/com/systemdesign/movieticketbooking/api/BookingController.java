package com.systemdesign.movieticketbooking.api;

import com.systemdesign.movieticketbooking.model.Seat;
import com.systemdesign.movieticketbooking.model.Show;
import com.systemdesign.movieticketbooking.services.BookingService;
import com.systemdesign.movieticketbooking.services.ShowService;
import com.systemdesign.movieticketbooking.services.TheatreService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {

    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    public BookingController(ShowService showService, BookingService bookingService, TheatreService theatreService) {
        this.showService = showService;
        this.bookingService = bookingService;
        this.theatreService = theatreService;
    }

    public String createBooking(final  String userId, final  String showId, List<String> seatIds){
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId,show,seats).getId();
    }
}
