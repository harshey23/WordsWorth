package com.wordsworth.backend.repository;

import com.wordsworth.backend.model.Lobby;

import java.util.Optional;

public interface LobbyRepository {
    void save(Lobby lobby);
    Optional<Lobby> findByRoomCode(String roomCode);
    boolean existsByRoomCode(String roomCode);
}
