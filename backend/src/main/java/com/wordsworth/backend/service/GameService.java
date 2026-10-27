package com.wordsworth.backend.service;

import com.wordsworth.backend.model.*;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.Instant;

import com.wordsworth.backend.repository.GameRepository;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GameService {

    private final GameRepository gameRepository;

    private static final long TRANSITION_DELAY_SECONDS = 3;
    private final Map<String, Instant> transitionDeadlines =
            new ConcurrentHashMap<>();

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createAndStartGame(
            GameMode gameMode,
            int totalRounds,
            int durationSeconds,
            List<Player> players) {

        if (gameMode == null) {
            throw new IllegalArgumentException(
                    "Game mode is required."
            );
        }

        if (totalRounds < 1 || totalRounds > 10) {
            throw new IllegalArgumentException(
                    "Total rounds must be between 1 and 10."
            );
        }

        if (durationSeconds != 5
                && durationSeconds != 10
                && durationSeconds != 15) {
            throw new IllegalArgumentException(
                    "Round duration must be 5, 10, or 15 seconds."
            );
        }

        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one player is required."
            );
        }

        if (gameMode == GameMode.SINGLE_PLAYER
                && players.size() != 1) {
            throw new IllegalArgumentException(
                    "Single-player games require exactly one player."
            );
        }

        if (gameMode == GameMode.MULTIPLAYER
                && players.size() < 2) {
            throw new IllegalArgumentException(
                    "Multiplayer games require at least two players."
            );
        }

        Game game = new Game(
                gameMode,
                totalRounds,
                players
        );

        for (int roundNumber = 1;
             roundNumber <= totalRounds;
             roundNumber++) {

            char startingLetter = generateStartingLetter();

            GameRound round = new GameRound(
                    roundNumber,
                    startingLetter,
                    durationSeconds
            );

            game.addRound(round);
        }

        game.start();
        gameRepository.save(game);

        return game;
    }

    private char generateStartingLetter() {
        return (char) ThreadLocalRandom.current()
                .nextInt('A', 'Z' + 1);
    }
}