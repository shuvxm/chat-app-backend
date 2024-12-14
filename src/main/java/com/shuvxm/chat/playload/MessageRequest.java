//package com.shuvxm.chat.playload;
//
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
////@Builder
//public class MessageRequest {
//    private String content;
//    private String sender;
//    private String roomId;
//
////    private LocalDateTime messageTime;
//}
package com.shuvxm.chat.playload;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String content;
    private String sender;
    private String roomId;
    private LocalDateTime messageTime;

}
