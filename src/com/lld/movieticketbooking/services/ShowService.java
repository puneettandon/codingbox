package com.lld.movieticketbooking.services;

import com.lld.cache.exceptions.NotFoundException;
import com.lld.movieticketbooking.exceptions.ScreenAlreadyOccupiedException;
import com.lld.movieticketbooking.model.Movie;
import com.lld.movieticketbooking.model.Screen;
import com.lld.movieticketbooking.model.Show;

import java.util.*;

public class ShowService {

    private final Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show getShow(final String showId) {
        if (!shows.containsKey(showId)) {
            throw new NotFoundException();
        }
        return shows.get(showId);
    }

    public Show createShow( final Movie movie,  final Screen screen,  final Date startTime,
                            final Integer durationInSeconds) {
        if (!checkIfShowCreationAllowed(screen, startTime, durationInSeconds)) {
            throw new ScreenAlreadyOccupiedException();
        }
        String showId = UUID.randomUUID().toString();
        final Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        this.shows.put(showId, show);
        return show;
    }

    private List<Show> getShowsForScreen(final Screen screen) {
        final List<Show> response = new ArrayList<>();
        for (Show show : shows.values()) {
            if (show.getScreen().equals(screen)) {
                response.add(show);
            }
        }
        return response;
    }

    private boolean checkIfShowCreationAllowed(final Screen screen, final Date startTime, final Integer durationInSeconds) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }
}
