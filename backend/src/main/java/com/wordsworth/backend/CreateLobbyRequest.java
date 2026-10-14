package com.wordsworth.backend;

public class CreateLobbyRequest {
    private String playerName;

    public CreateLobbyRequest(){}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
