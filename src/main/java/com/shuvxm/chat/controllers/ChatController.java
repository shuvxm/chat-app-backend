package com.shuvxm.chat.controllers;

import com.shuvxm.chat.entity.Message;
import com.shuvxm.chat.entity.Room;
import com.shuvxm.chat.exceptionclasses.NoRoomIdFoundException;
import com.shuvxm.chat.playload.MessageRequest;
import com.shuvxm.chat.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private RoomRepository roomRepository;

    // for sending and receiving messages
    @MessageMapping("/sendMessage/{roomId}")  // /app/sendMessage/roomId -> to send msg
    @SendTo("/topic/room/{roomId}")   // for subscribing to chat
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ){
       Room room = roomRepository.findByRoomId(request.getRoomId());

        if (room != null) {
            Message message = new Message(request.getContent(), request.getSender());
            message.setTimeStamp(LocalDateTime.now());
            room.getMessages().add(message);
            roomRepository.save(room); return message;
        }
        else {
//            throw new RuntimeException();
            throw NoRoomIdFoundException.builder().message("Room ID not found").build();
        }
    }

}
