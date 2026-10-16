package com.wordsworth.backend.repository;

import com.wordsworth.backend.model.Lobby;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryLobbyRepository implements LobbyRepository {

    private final ConcurrentHashMap<String, Lobby> lobbies = new ConcurrentHashMap<>();

    @Override
    public void save(Lobby lobby) {
        lobbies.put(lobby.getRoomCode(), lobby);
    }

    @Override
    public Optional<Lobby> findByRoomCode(String roomCode) {
        return Optional.ofNullable(lobbies.get(roomCode));
    }

    @Override
    public boolean existsByRoomCode(String roomCode) {
        return lobbies.containsKey(roomCode);
    }
}
