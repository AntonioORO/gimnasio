package com.aoro.gimnasio.model;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class ResponseLoginVo {
	private String token;
	private Date expired;

	private String rol;
	private UsuarioVo usuario;
	private String img;

}
