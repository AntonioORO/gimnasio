package com.aoro.gimnasio.config.controller.request;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

	private String nombre;
	private String apaterno;
	private String amaterno;
	private String password;
	private String nick;
	private Integer intentos;
	private Date fecha_alta;
	private Date fecha_modificacion;
	private String img_url;
	private Integer activo;
	private long rol;
	private long id;
	
}
