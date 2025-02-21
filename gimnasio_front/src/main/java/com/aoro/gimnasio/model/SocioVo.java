package com.aoro.gimnasio.model;

import java.util.Date;

import lombok.Data;

@Data

public class SocioVo {

	public SocioVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SocioVo(Long id, String nombre, String apaterno, String amaterno, Date fecha_nacimiento,
			MembresiaVo membresia, Date inicio_membresia, byte[] huella_uno, byte[] huella_dos, Long usuario_crea,
			Long usuario_modifica, Long usuario_responsable, Date fecha_alta, Date fecha_modificacion,
			Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.fecha_nacimiento = fecha_nacimiento;
		this.membresia = membresia;
		this.inicio_membresia = inicio_membresia;
		this.huella_uno = huella_uno;
		this.huella_dos = huella_dos;
		this.usuario_crea = usuario_crea;
		this.usuario_modifica = usuario_modifica;
		this.usuario_responsable = usuario_responsable;
		this.fecha_alta = fecha_alta;
		this.fecha_modificacion = fecha_modificacion;
		this.activo = activo;
	}

	private Long id;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private Date fecha_nacimiento;
	private MembresiaVo membresia;
	private Date inicio_membresia;
	private byte[] huella_uno;
	private byte[] huella_dos;
	private Long usuario_crea;
	private Long usuario_modifica;
	private Long usuario_responsable;
	private Date fecha_alta;
	private Date fecha_modificacion;
	private Integer activo;

}
