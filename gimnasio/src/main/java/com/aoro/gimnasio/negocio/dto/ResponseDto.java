package com.aoro.gimnasio.negocio.dto;

import lombok.Data;

@Data
public class ResponseDto {
	private int codigo;
	private String message;
	private Object data;
}
