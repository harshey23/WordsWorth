package com.wordsworth.backend.controller;

import com.wordsworth.backend.dto.request.CreateLobbyRequest;
import com.wordsworth.backend.model.Lobby;
import com.wordsworth.backend.service.LobbyService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/lobbies")
public class LobbyController {
    private final LobbyService lobbyService;

    public LobbyController(LobbyService lobbyService){
        this.lobbyService = lobbyService;
    }

    @PostMapping
    public Lobby createLobby(@RequestBody CreateLobbyRequest request){
        return lobbyService.createLobby(request.getPlayerName(),request.getTotalRounds());
    }
}
