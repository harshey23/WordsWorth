package com.wordsworth.backend.model;

public class Player {

    private String playerId;
    private String playerName;
    private boolean host;
    private int totalScore;

    public Player(String playerId, String playerName, boolean host) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.host = host;
        this.totalScore = 0;
    }
    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isHost() {
        return host;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addScore(int points) {
        this.totalScore += points;
    }
}
