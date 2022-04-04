package com.lld.movieticketbooking.providers;

import com.lld.movieticketbooking.model.Seat;
import com.lld.movieticketbooking.model.Show;

import java.util.List;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seats, String user);
    void unlockSeats(Show show, List<Seat> seats,String user);
    boolean validateLock(Show show,Seat seat,String user);

    List<Seat> getLockedSeats(Show show);
}
