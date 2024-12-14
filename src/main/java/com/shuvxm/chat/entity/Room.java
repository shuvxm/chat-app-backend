package com.shuvxm.chat.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rooms") // Marks this class as a MongoDB document & Specifies the MongoDB collection name
public class Room {
    @Id
    private String id; // MongoDB's unique identifier for the document
    private String roomId; // Custom room identifier
    private List<Message> messages = new ArrayList<>(); // List of messages in the room

//    // Ensure getter and setter methods for `messages` field are present
//    public List<Message> getMessages() {
//        return messages;
//    }
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
//
//    public void setRoomId(String roomId) {
//    }
}
