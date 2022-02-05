package com.systemdesign.snakeladder;

import java.util.Objects;

public class Player {

    private String playerName;
    private int id;

    public Player(String playerName, int id) {
        this.playerName = playerName;
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && playerName.equals(player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, id);
    }
}
