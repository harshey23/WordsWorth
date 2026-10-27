package com.wordsworth.backend.repository;

import com.wordsworth.backend.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {

    void save(Game game);

    Optional<Game> findByGameId(String gameId);

    List<Game> findAll();
}