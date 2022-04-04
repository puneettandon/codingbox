package com.lld.movieticketbooking.services;

import com.lld.movieticketbooking.exceptions.BadRequestException;
import com.lld.movieticketbooking.model.Booking;
import com.lld.movieticketbooking.providers.SeatLockProvider;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    private final Integer allowedRetries;
    private final SeatLockProvider seatLockProvider;
    private Map<Booking,Integer> bookingFailures;

    public PaymentService(Integer allowedRetries, SeatLockProvider seatLockProvider, Map<Booking, Integer> bookingFailures) {
        this.allowedRetries = allowedRetries;
        this.seatLockProvider = seatLockProvider;
        this.bookingFailures = new HashMap<>();
    }

    public void proceesPaymentFailed(final Booking booking, final String user ){
        if(!booking.getUser().equals(user)){
            throw new BadRequestException();
        }
        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking,0);
        }
        final Integer currentFailuresCount = bookingFailures.get(booking);
        final Integer newFailuresCount = currentFailuresCount + 1;
        bookingFailures.put(booking,newFailuresCount);
        if(newFailuresCount > allowedRetries){
            seatLockProvider.unlockSeats(booking.getShow(),booking.getSeatsBooked(),booking.getUser());
        }
    }
}
