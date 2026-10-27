package com.wordsworth.backend.service;

import com.wordsworth.backend.model.Lobby;
import com.wordsworth.backend.model.Player;
import com.wordsworth.backend.repository.LobbyRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class LobbyService {

    private final LobbyRepository lobbyRepository;

    public LobbyService(LobbyRepository lobbyRepository) {
        this.lobbyRepository = lobbyRepository;
    }

    public Lobby createLobby(String playerName, int totalRounds, int roundDurationSeconds){
        if(playerName == null || playerName.isBlank()){
            throw new IllegalArgumentException("Player name can't be empty!");
        }
        if(totalRounds < 1 || totalRounds > 10){
            throw new IllegalArgumentException("Number of rounds should be between 1 and 10");
        }
        if (roundDurationSeconds != 5
                && roundDurationSeconds != 10
                && roundDurationSeconds != 15) {
            throw new IllegalArgumentException(
                    "Round duration must be 5, 10, or 15 seconds."
            );
        }
        String roomCode;
        do{
            roomCode  = generateRoomCode();
        }while(lobbyRepository.existsByRoomCode(roomCode));

        Player host = new Player(UUID.randomUUID().toString(),playerName.trim(),true);

        Lobby lobby = new Lobby(roomCode,host,totalRounds, roundDurationSeconds);
        lobbyRepository.save(lobby);
        return lobby;
    }

    private String generateRoomCode(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ23456789";
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 6; i++){
            int index = ThreadLocalRandom.current().nextInt(characters.length());
            code.append(characters.charAt(index));
        }
        return code.toString();
    }
}
