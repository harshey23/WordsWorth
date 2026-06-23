package com.wordsworth.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {

    private String roomCode;
    private GameState state = GameState.LOBBY;
    private List<Player> players = new ArrayList<>();
}
