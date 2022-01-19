package com.systemdesign.movieticketbooking.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final String id;
    private final String name;
    private final List<Screen> screens;

    // other theatre metadata


    public Theatre(String id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<Screen>();
    }

    public  void addScreen(final Screen screen){
        screens.add(screen);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
