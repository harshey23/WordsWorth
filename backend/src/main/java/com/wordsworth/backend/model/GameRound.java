package com.wordsworth.backend.model;

import java.util.UUID;
import java.time.Instant;

public class GameRound {
    private final String roundId;
    private final int roundNumber;
    private final char startingLetter;

    private final int durationSeconds;
    private RoundStatus roundStatus;

    private Instant startedAt;
    private Instant deadline;

    public String getRoundId() {
        return roundId;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public char getStartingLetter() {
        return startingLetter;
    }

    public RoundStatus getRoundStatus() {
        return roundStatus;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public GameRound(
            int roundNumber,
            char startingLetter,
            int durationSeconds) {

        if (roundNumber < 1) {
            throw new IllegalArgumentException(
                    "Round number must be positive."
            );
        }

        if (durationSeconds < 1) {
            throw new IllegalArgumentException(
                    "Round duration must be positive."
            );
        }

        this.roundId = UUID.randomUUID().toString();
        this.roundNumber = roundNumber;
        this.startingLetter = Character.toUpperCase(startingLetter);
        this.durationSeconds = durationSeconds;
        this.roundStatus = RoundStatus.NOT_STARTED;
    }

    public void start(){
        if(roundStatus!=RoundStatus.NOT_STARTED){
            throw new IllegalStateException(
                    "Only a round that has not started can be started."
            );
        }

        startedAt = Instant.now();
        deadline = startedAt.plusSeconds(durationSeconds);

        roundStatus = RoundStatus.IN_PROGRESS;
    }

    public boolean canAcceptSubmissions() {
        return roundStatus == RoundStatus.IN_PROGRESS
                && Instant.now().isBefore(deadline);
    }

    public void complete() {
        if (roundStatus != RoundStatus.IN_PROGRESS) {
            throw new IllegalStateException(
                    "Only an active round can be completed."
            );
        }
        roundStatus = RoundStatus.COMPLETED;
    }

}
