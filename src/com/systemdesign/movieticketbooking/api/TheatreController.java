package com.systemdesign.movieticketbooking.api;


import com.systemdesign.movieticketbooking.model.Screen;
import com.systemdesign.movieticketbooking.model.Theatre;
import com.systemdesign.movieticketbooking.services.TheatreService;

public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(final String theatreName){
        return theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(final String screenName,final String theatreId){
        final Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName,theatre).getId();
    }

    public String createSeatInScreen(final Integer rowNo, final Integer seatNo,final String screenId){
        final Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowNo,seatNo,screen).getId();
    }
}
