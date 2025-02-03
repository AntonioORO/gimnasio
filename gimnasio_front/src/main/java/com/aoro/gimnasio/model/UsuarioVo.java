package com.aoro.gimnasio.model;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class UsuarioVo {

	public UsuarioVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioVo(Long id, String nombre, String apaterno, String amaterno, String password, String nick,
			Integer intentos, Date fecha_alta, Date fecha_modificacion, String img_url, Integer activo, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.password = password;
		this.nick = nick;
		this.intentos = intentos;
		this.fecha_alta = fecha_alta;
		this.fecha_modificacion = fecha_modificacion;
		this.img_url = img_url;
		this.activo = activo;
	}
	private Long id;
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
	private String img;

}
