package com.wordsworth.backend.model;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class Game {
    private final String gameId;
    private final GameMode gameMode;
    private final int totalRounds;
    private final List<Player> players;

    private int currentRound;
    private GameStatus status;

    private final List<GameRound> rounds;

    public Game(GameMode gameMode, int totalRounds, List<Player> players) {
        this.gameId = UUID.randomUUID().toString();
        this.gameMode = gameMode;
        this.totalRounds = totalRounds;
        this.players = new java.util.ArrayList<>(players);
        this.currentRound = 0;
        this.status = GameStatus.NOT_STARTED;
        this.rounds = new java.util.ArrayList<>();
    }
    public String getGameId() {
        return gameId;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public GameStatus getStatus() {
        return status;
    }

    public List<GameRound> getRounds() {
        return List.copyOf(rounds);
    }

    public void addRound(GameRound round) {
        if (status != GameStatus.NOT_STARTED) {
            throw new IllegalStateException(
                    "Cannot add rounds after the game has started."
            );
        }

        if (rounds.size() >= totalRounds) {
            throw new IllegalStateException(
                    "The game already has all its rounds."
            );
        }

        rounds.add(round);
    }

    public void start() {
        if (status != GameStatus.NOT_STARTED) {
            throw new IllegalStateException(
                    "Only a game that has not started can be started."
            );
        }

        if (rounds.size() != totalRounds) {
            throw new IllegalStateException(
                    "All rounds must be configured before starting the game."
            );
        }

        status = GameStatus.IN_PROGRESS;
        currentRound = 1;
        rounds.get(0).start();
    }

    public void finishCurrentRound(){
        if(status != GameStatus.IN_PROGRESS){
            throw new IllegalStateException(
                    "The game is not in progress."
            );
        }
        rounds.get(currentRound - 1).complete();
    }
    public void advanceToNextRound() {
        if (status != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException(
                    "The game is not in progress."
            );
        }

        if (rounds.get(currentRound - 1).getRoundStatus()
                != RoundStatus.COMPLETED) {
            throw new IllegalStateException(
                    "The current round must finish before advancing."
            );
        }

        if (currentRound >= totalRounds) {
            status = GameStatus.COMPLETED;
            return;
        }

        currentRound++;
        rounds.get(currentRound - 1).start();
    }
    public GameRound getCurrentGameRound() {
        if (currentRound < 1 || currentRound > rounds.size()) {
            return null;
        }

        return rounds.get(currentRound - 1);
    }
}
