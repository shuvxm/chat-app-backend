package com.shuvxm.chat.exceptionclasses;

import lombok.Getter;
import lombok.Builder;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoRoomIdFoundException extends RuntimeException {
    private String message;

    public String getMessage() {
        return this.message = message;
    }
}
