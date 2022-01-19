package com.systemdesign.movieticketbooking.model;

import com.systemdesign.movieticketbooking.exceptions.InvalidStateException;

import java.util.List;

public class Booking {

    private final String id;
    private final Show show;
    private List<Seat> seatsBooked;
    private final String user;
    private BookingStatus bookingStatus;

    public Booking(String id, Show show, String user,List<Seat> seatsBooked) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.user = user;
        this.bookingStatus = BookingStatus.Created;
    }

    public  boolean isConfirmed(){ return this.bookingStatus ==  BookingStatus.Confirmed; }

    public void confirmBooking(){
        if(this.bookingStatus != BookingStatus.Created){
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.Confirmed;
    }

    public void expireBooking(){
        if(this.bookingStatus != BookingStatus.Created){
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.Expired;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public String getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

}
