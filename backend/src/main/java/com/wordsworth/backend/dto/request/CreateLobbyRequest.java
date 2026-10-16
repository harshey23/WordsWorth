
package com.wordsworth.backend.dto.request;

public class CreateLobbyRequest {

    private String playerName;
    private int totalRounds;

    public CreateLobbyRequest() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }
}
