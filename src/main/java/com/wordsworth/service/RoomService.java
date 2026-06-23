package com.wordsworth.service;

import com.wordsworth.model.Player;
import com.wordsworth.model.Room;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoomService {

    private final Map<String, Room> rooms = new ConcurrentHashMap<>();

    public Room createRoom(String playerName){
        String roomCode = generateRoomCode();

        Player host = new Player(UUID.randomUUID().toString(), playerName, true);
        Room room = new Room();
        room.setRoomCode(roomCode);
        room.getPlayers().add(host);

        rooms.put(roomCode,room);
        return room;
    }

    public Player joinRoom(String roomCode, String playerName){
        Room room = rooms.get(roomCode);

        if(room == null){
            throw new RuntimeException("Room not found");
        }
        Player player = new Player(UUID.randomUUID().toString(), playerName, false);

        room.getPlayers().add(player);
        return player;
    }

    public Room getRoom(String roomCode){
        return rooms.get(roomCode);
    }

    private String generateRoomCode() {
        return UUID.randomUUID().toString().substring(0,4).toUpperCase();
    }
}
