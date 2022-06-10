package com.lld.movieticketbooking.tdd.src;

import java.util.ArrayList;
import java.util.List;

public class MyTheatre {

    String theatreId;
    String theatreName;
    List<MyScreen> screens;

    public MyTheatre(String theatreId, String theatreName) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.screens = new ArrayList<>();
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void addScreen(MyScreen screen){
        this.screens.add(screen);
    }
}
