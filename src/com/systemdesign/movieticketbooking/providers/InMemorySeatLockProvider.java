package com.systemdesign.movieticketbooking.providers;

import com.systemdesign.movieticketbooking.exceptions.SeatTemporaryUnavailableException;
import com.systemdesign.movieticketbooking.model.Seat;
import com.systemdesign.movieticketbooking.model.SeatLock;
import com.systemdesign.movieticketbooking.model.Show;

import java.util.*;

public class InMemorySeatLockProvider implements SeatLockProvider{

    private final Integer lockTimeout;
    private Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProvider(Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        this.locks = new HashMap<>();
    }

    @Override
    public void lockSeats( Show show,  List<Seat> seats,  String user) {
        for(Seat seat: seats){
            if(isSeatLocked(show,seat)){
                throw new SeatTemporaryUnavailableException();
            }
        }
        for(Seat seat: seats){
            lockSeat(show,seat,user,lockTimeout);
        }
    }

    private void lockSeat(Show show, Seat seat, String user, Integer timeoutInSeconds) {
        if(!locks.containsKey(show)){
            locks.put(show,new HashMap<>());
        }
        final SeatLock lock = new SeatLock(seat,show,timeoutInSeconds,new Date(),user);
        locks.get(show).put(seat,lock);
    }

    private boolean isSeatLocked(Show show, Seat seat) {
        return locks.containsKey(show) && locks.get(show).containsKey(seat) && !locks.get(show).get(seat).isLockedExpired();
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat: seats){
            if(validateLock(show,seat,user)){
                unlockSeat(show,seat);
            }
        }
    }

    private void unlockSeat(Show show, Seat seat) {
        if(!locks.containsKey(show)){
            return;
        }
        locks.get(show).remove(seat);
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        return isSeatLocked(show,seat) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
       if(!locks.containsKey(show)){
           return List.of();
       }
       final List<Seat> lockedSeats = new ArrayList<>();

       for(Seat seat: locks.get(show).keySet()){
            if(isSeatLocked(show,seat)){
                lockedSeats.add(seat);
            }
       }
       return lockedSeats;
    }
}
