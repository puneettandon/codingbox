package com.lld.movieticketbooking.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private final String id;
    private final String name;
    private final Theatre theatre;

    // other meta data

    private final List<Seat> seats;

    public Screen(final String id, final String name, final Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seats = new ArrayList<Seat>();
    }

    public  void addSeat(final Seat seat){
        this.seats.add(seat);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
