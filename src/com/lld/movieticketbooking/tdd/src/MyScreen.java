package com.lld.movieticketbooking.tdd.src;

import java.util.ArrayList;
import java.util.List;

public class MyScreen {

    String screenId;
    String screenName;
    MyTheatre theatre;
    List<MySeat> seats;

    public MyScreen(String screenId, String screenName, MyTheatre theatre) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public String getScreenId() {
        return screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public MyTheatre getTheatre() {
        return theatre;
    }

    public void addSeat(MySeat seat) {
        this.seats.add(seat);
    }

}
