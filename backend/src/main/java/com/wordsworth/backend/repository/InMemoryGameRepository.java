package com.wordsworth.backend.repository;

import com.wordsworth.backend.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class InMemoryGameRepository implements GameRepository{

    private final ConcurrentMap<String,Game> games = new ConcurrentHashMap<>();

    @Override
    public void save(Game game) {
        games.put(game.getGameId(),game);
    }

    @Override
    public Optional<Game> findByGameId(String gameId) {
        return Optional.ofNullable(games.get(gameId));
    }

    @Override
    public List<Game> findAll() {
        return List.copyOf(games.values());
    }
}
