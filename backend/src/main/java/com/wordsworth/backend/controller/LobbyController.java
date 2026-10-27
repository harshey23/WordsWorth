package com.wordsworth.backend.controller;

import com.wordsworth.backend.dto.request.CreateLobbyRequest;
import com.wordsworth.backend.dto.response.LobbyResponse;
import com.wordsworth.backend.model.Lobby;
import com.wordsworth.backend.service.LobbyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/lobbies")
public class LobbyController {
    private final LobbyService lobbyService;

    public LobbyController(LobbyService lobbyService){
        this.lobbyService = lobbyService;
    }

    /**
     * Creates a new game lobby for the requesting host.
     */
    @PostMapping
    public ResponseEntity<LobbyResponse> createLobby(
          @Valid @RequestBody CreateLobbyRequest request) {

        Lobby lobby = lobbyService.createLobby(
                request.getPlayerName(),
                request.getTotalRounds(),
                request.getRoundDurationSeconds()
        );

        LobbyResponse response = LobbyResponse.from(lobby);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}