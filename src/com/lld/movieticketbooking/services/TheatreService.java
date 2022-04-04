package com.lld.movieticketbooking.services;

import com.lld.cache.exceptions.NotFoundException;
import com.lld.movieticketbooking.model.Screen;
import com.lld.movieticketbooking.model.Seat;
import com.lld.movieticketbooking.model.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private  final Map<String, Theatre> theatres;
    private final Map<String, Screen> screens;
    private final Map<String, Seat> seats;

    public TheatreService(){
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }

    public Theatre createTheatre(final String theatreName){
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId,theatreName);
        theatres.put(theatreId,theatre);
        return theatre;
    }

    public Theatre getTheatre(final String theatreId){
        if(!theatres.containsKey(theatreId)){
            throw new NotFoundException();
        }
        return theatres.get(theatreId);
    }

    public Screen createScreenInTheatre(final String screenName,final Theatre theatre){
        Screen screen = createScreen(screenName,theatre);
        theatre.addScreen(screen);
        return screen;
    }

    private Screen createScreen(String screenName, Theatre theatre) {
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId,screenName,theatre);
        screens.put(screenId,screen);
        return screen;
    }

    public Screen getScreen(final String screenId){
        if(!screens.containsKey(screenId)){
            throw new NotFoundException();
        }
        return screens.get(screenId);
    }

    public Seat createSeatInScreen(final Integer rowNo,final Integer seatNo, final Screen screen){
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId,rowNo,seatNo);
        seats.put(seatId,seat);
        screen.addSeat(seat);
        return seat;
    }

    public Seat getSeat(final  String seatId){
        if(!seats.containsKey(seatId)){
            throw new NotFoundException();
        }
        return seats.get(seatId);
    }
}
