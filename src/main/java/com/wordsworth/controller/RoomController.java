package com.wordsworth.controller;

import com.wordsworth.dto.CreateRoomResponse;
import com.wordsworth.dto.JoinRoomRequest;
import com.wordsworth.dto.JoinRoomResponse;
import com.wordsworth.model.Player;
import com.wordsworth.model.Room;
import com.wordsworth.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//further game logic , websockets on STOMP etc , don't add extra bro.
@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public CreateRoomResponse createRoom(@RequestParam String playerName){
        Room room = roomService.createRoom(playerName);
        String hostId = room.getPlayers().getFirst().getId();

        return new CreateRoomResponse(room.getRoomCode(),hostId);
    }

    @PostMapping("/join")
    public JoinRoomResponse joinRoom(@RequestBody JoinRoomRequest request){
        Player player = roomService.joinRoom(request.roomCode(), request.playerName());

        return new JoinRoomResponse(player.getId());
    }

    @GetMapping("/{roomCode}")
    public Room getRoom(@PathVariable String roomCode){
        return roomService.getRoom(roomCode);
    }

}
