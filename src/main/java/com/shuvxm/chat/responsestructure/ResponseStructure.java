package com.shuvxm.chat.responsestructure;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseStructure<T> 
{
	private int status;
	private String message;
	private T body;

}
