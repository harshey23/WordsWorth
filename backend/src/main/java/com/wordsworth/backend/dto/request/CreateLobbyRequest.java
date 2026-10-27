
package com.wordsworth.backend.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateLobbyRequest {

    @NotBlank(message = "Name can't be empty.")
    @Size(max = 20, message = "Name can't exceed 20 characters")
    private String playerName;

    @Max(value = 10, message = "Maximum of 10 rounds are allowed.")
    @Min(value = 1, message = "At least 1 round is required to play.")
    private int totalRounds;
    private int roundDurationSeconds = 15;

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

    public int getRoundDurationSeconds() {
        return roundDurationSeconds;
    }
    public void setRoundDurationSeconds(int roundDurationSeconds) {
        this.roundDurationSeconds = roundDurationSeconds;
    }
}
