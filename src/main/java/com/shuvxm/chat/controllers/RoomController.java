package com.shuvxm.chat.controllers;

import com.shuvxm.chat.service.RoomService;
import com.shuvxm.chat.entity.Room;
import com.shuvxm.chat.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:5173")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomRepository roomRepository;

	// create room
//	@PostMapping
//	public ResponseEntity<?> createRoom(@RequestBody String roomId) {
//		return roomService.createRoom(roomId);
//	}
	@PostMapping
	public ResponseEntity<?> createRoom(@RequestBody String roomId) {
	    roomId = roomId.replace("\"", "").trim(); // Remove extra quotes
//	    System.out.println("Creating room with ID: " + roomId);
	    return roomService.createRoom(roomId);
	}


	
	// get room : join
//	return roomService.findByRoomId(roomId);

	@GetMapping("/{roomId}")
	public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
		return roomService.joinRoom(roomId);
	}


	// get messages of room
	@GetMapping("/{roomId}/messages")
	public ResponseEntity<?> getMessages(
			@PathVariable String roomId,
			@RequestParam(value = "page", defaultValue = "0", required=false) int page,
			@RequestParam(value = "size", defaultValue = "20", required=false) int size
	)
	{
		return roomService.getMessages(roomId, page, size);
	}

}
