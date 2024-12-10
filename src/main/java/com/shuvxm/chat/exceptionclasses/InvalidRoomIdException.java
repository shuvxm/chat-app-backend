package com.shuvxm.chat.exceptionclasses;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidRoomIdException extends RuntimeException {
	private String message;

    public String getMessage() {
        return this.message = message;
    }
}
