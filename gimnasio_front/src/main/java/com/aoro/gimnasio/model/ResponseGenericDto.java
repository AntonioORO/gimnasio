package com.aoro.gimnasio.model;

import lombok.Data;

@Data
public class ResponseGenericDto {
	private int codigo ;
	private String message;
	private Object data;
	 
}
