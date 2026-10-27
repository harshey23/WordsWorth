package com.wordsworth.backend.dto.response;

import com.wordsworth.backend.model.Lobby;
import com.wordsworth.backend.model.LobbyStatus;
import com.wordsworth.backend.model.Player;

public class LobbyResponse {

    private final String roomCode;
    private final String hostId;
    private final String hostName;
    private final int playerCount;
    private final int totalRounds;
    private final LobbyStatus status;
    private final int roundDurationSeconds;

    public String getRoomCode() {
        return roomCode;
    }

    public String getHostId() {
        return hostId;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public LobbyStatus getStatus() {
        return status;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getRoundDurationSeconds() { return roundDurationSeconds; }

    public LobbyResponse(String roomCode, String hostId, String hostName, int playerCount,
                         int totalRounds, LobbyStatus status, int roundDurationSeconds) {
        this.roomCode = roomCode;
        this.hostId = hostId;
        this.hostName = hostName;
        this.playerCount = playerCount;
        this.totalRounds = totalRounds;
        this.status = status;
        this.roundDurationSeconds = roundDurationSeconds;
    }

    public static LobbyResponse from(Lobby lobby){
        Player host = lobby.getHost();
        return new LobbyResponse(lobby.getRoomCode(), host.getPlayerId(), host.getPlayerName(),
                lobby.getPlayers().size(), lobby.getTotalRounds(), lobby.getStatus(), lobby.getRoundDurationSeconds());
    }


}
