package com.wordsworth.backend.model;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    private final String roomCode;
    private final Player host;
    private final List<Player> players = new ArrayList<>();
    private final int totalRounds;

    private LobbyStatus status;

    public Lobby(String roomCode, Player host, int totalRounds) {
        this.roomCode = roomCode;
        this.host = host;
        this.totalRounds = totalRounds;
        this.status = LobbyStatus.WAITING;

        players.add(host);
    }

    public String getRoomCode(){
        return roomCode;
    }
    public Player getHost(){
        return host;
    }
    public List<Player> getPlayers(){
        return List.copyOf(players);
    }
    public int getTotalRounds() {
        return totalRounds;
    }

    public LobbyStatus getStatus() {
        return status;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame(){
        if(status != LobbyStatus.WAITING){
            throw new IllegalStateException("Only a waiting lobby can start the game.");
        }
        status = LobbyStatus.IN_PROGRESS;
    }

    public void finishGame(){
        if(status != LobbyStatus.IN_PROGRESS){
            throw new IllegalStateException("Only an active game can be finished.");
        }
        status = LobbyStatus.FINISHED;
    }
}
