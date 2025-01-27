package com.shuvxm.chat.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomNotFoundException extends RuntimeException {
	private String message;

    public String getMessage() {
        return this.message = message;
    }
}
