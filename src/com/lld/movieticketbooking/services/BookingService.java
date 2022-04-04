package com.lld.movieticketbooking.services;

import com.lld.cache.exceptions.NotFoundException;
import com.lld.movieticketbooking.exceptions.BadRequestException;
import com.lld.movieticketbooking.exceptions.SeatPermanentUnavailableException;
import com.lld.movieticketbooking.model.Booking;
import com.lld.movieticketbooking.model.Seat;
import com.lld.movieticketbooking.model.Show;
import com.lld.movieticketbooking.providers.SeatLockProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private  final SeatLockProvider seatLockProvider;
    private final Map<String,Booking> showBooking;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.showBooking = new HashMap<>();
    }

    public Booking createBooking(final String userId, final Show show, final List<Seat> seats){
        if(isAnySeatAlreadyBooked(show,seats)){
            throw new SeatPermanentUnavailableException();
        }
        seatLockProvider.lockSeats(show,seats,userId);
        final String bookingId = UUID.randomUUID().toString();
        final Booking newBooking = new Booking(bookingId,show,userId,seats);
        showBooking.put(bookingId,newBooking);
        return newBooking;
    }

    private boolean isAnySeatAlreadyBooked(Show show, List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for(Seat seat : seats){
            if(bookedSeats.contains(seat)){
                return true;
            }
        }
        return false;
    }

    public List<Seat> getBookedSeats(final Show show) {
        return getAllBookings(show).stream()
                .filter(Booking :: isConfirmed)
                .map(Booking:: getSeatsBooked)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings( final Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : showBooking.values()) {
            if (booking.getShow().equals(show)) {
                response.add(booking);
            }
        }

        return response;
    }

    public void confirmBooking(final Booking booking , final String user){
        if(!booking.getUser().equals(user)){
            throw new BadRequestException();
        }
        for(Seat seat: booking.getSeatsBooked()){
            if(!seatLockProvider.validateLock(booking.getShow(),seat,user)){
                throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }

    public Booking getBooking( final String bookingId) {
        if (!showBooking.containsKey(bookingId)) {
            throw new NotFoundException();
        }
        return showBooking.get(bookingId);
    }
}
