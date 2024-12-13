package com.shuvxm.chat.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timeStamp = LocalDateTime.now(); // Assigns the current time
    }
//    public LocalDateTime getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(LocalDateTime timeStamp) {
//        this.timeStamp = timeStamp;
//    }


}
