package com.lld.movieticketbooking.tdd.src;

import java.util.HashMap;

public class MyTheatreService {

    private final HashMap<String, MyTheatre> theatres;
    private final HashMap<String, MyScreen> screens;
    private final HashMap<String, MySeat> seats;

    public MyTheatreService(HashMap<String, MyTheatre> theatres, HashMap<String, MyScreen> screens, HashMap<String, MySeat> seats) {
        this.theatres = theatres;
        this.screens = screens;
        this.seats = seats;
    }

    public MyTheatre createTheatre(String theatreName) {
        String theatreId = "111";
        MyTheatre theatre =  new MyTheatre(theatreId,theatreName);
        theatres.put(theatreId,theatre);
        return theatre;
    }

    public MyTheatre getTheatre(String theatreId) {
        //   System.out.println("Check: "+theatres.containsKey(theatreId));
        if(!theatres.containsKey(theatreId)){
            throw new TheatreNotFoundException("Theatre Not found with this Id");
        }
        return theatres.get(theatreId);
    }

    public MyScreen createScreenInTheatre(String screenName, MyTheatre myTheatre) {
        String screenId = "1";
        MyScreen myScreen =  new MyScreen(screenId,screenName,myTheatre);
        screens.put(screenId,myScreen);
        return myScreen;
    }


    public MyScreen getScreen(String screenId) {
        if(!screens.containsKey(screenId)){
            throw new ScreenNotFoundException("Screen Not found with this screenId");
        }
        return screens.get(screenId);
    }

    public MySeat createSeatInScreen(String rowNo, String seatNo, MyScreen myScreen) {
        String seatId = "300";
        MySeat seat = new MySeat(seatId,rowNo,seatNo);
        seats.put(seatId,seat);
        myScreen.addSeat(seat);
        return seat;
    }
}
