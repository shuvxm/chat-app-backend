package com.shuvxm.chat.repository;

import com.shuvxm.chat.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoomRepository extends MongoRepository<Room, String> {

	// get room using room id
	Room findByRoomId(String roomId);

}
