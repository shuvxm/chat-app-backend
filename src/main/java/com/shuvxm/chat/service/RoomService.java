package com.shuvxm.chat.service;

import com.shuvxm.chat.entity.Message;
import com.shuvxm.chat.entity.Room;
import com.shuvxm.chat.exceptionclasses.InvalidRoomIdException;
import com.shuvxm.chat.exceptionclasses.NoRoomIdFoundException;
import com.shuvxm.chat.exceptionclasses.RoomNotFoundException;
import com.shuvxm.chat.repository.RoomRepository;
import com.shuvxm.chat.responsestructure.ResponseStructure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	public ResponseEntity<?> createRoom(String roomId) {
		// Check if a room with the same roomId already exists
		if (roomRepository.findByRoomId(roomId) != null) {
			throw InvalidRoomIdException.builder().message("Invalid room id. Room already exists.").build();
//			return ResponseEntity.badRequest().body("Room already exists!");
		}

		// Save the new room
		Room room = new Room();
		room.setRoomId(roomId);
		Room savedRoom = roomRepository.save(room);

		// Return success response
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder()
				.status(HttpStatus.CREATED.value()).message("Room successfully saved").body(room).build());
//		return ResponseEntity.status(HttpStatus.CREATED).body(room);
	}

//	public ResponseEntity<?> findByRoomId(String roomId) {
//		Room room = roomRepository.findByRoomId(roomId);
//		if(room == null)
//			throw  NoRoomIdFoundException.builder().message("No such roomId exists. Unable to find").build();
//		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
//				.status(HttpStatus.OK.value()).message("You have joined successfully with this roomId: " + roomId).body(room).build());
////		return new ResponseEntity<>("You have joined successfully with this roomId: " + roomId, HttpStatus.OK);
//	}
	

//	public ResponseEntity<?> findByRoomId(String roomId) {
//	    try {
//	        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFoundException("Room not found"));
//	        return ResponseEntity.ok(room);
//	    } catch (Exception e) {
//	        // Log the exception for debugging
//	        e.printStackTrace();
//	        return ResponseEntity.status(500).body("An unexpected error occurred: " + e.getMessage());
//	    }
//	}


	public ResponseEntity<?> getMessages(String roomId, int page, int size) {
		Room room = roomRepository.findByRoomId(roomId);
		if (room == null){
//			return ResponseEntity.badRequest().build();
			throw  NoRoomIdFoundException.builder().message("No such roomId exists. Unable to find").build();
		}
		// get messages
		// pagination
		List<Message> messages = room.getMessages();
		int start = Math.max(0, messages.size() - (page + 1) * size);
		int end = Math.min(messages.size(), start + size);
		List<Message> paginatedMessages = messages.subList(start, end);
		return ResponseEntity.ok(paginatedMessages);
	}

	public ResponseEntity<?> joinRoom(String roomId) {
		Room room = roomRepository.findByRoomId(roomId);
		if(room == null)
			throw  NoRoomIdFoundException.builder().message("No such roomId exists. Unable to find").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
				.status(HttpStatus.OK.value()).message("You have joined successfully with this roomId: " + roomId).body(room).build());
//		return new ResponseEntity<>("You have joined successfully with this roomId: " + roomId, HttpStatus.OK);
	}
}
