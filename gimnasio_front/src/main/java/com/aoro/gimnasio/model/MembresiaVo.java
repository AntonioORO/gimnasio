package com.aoro.gimnasio.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class MembresiaVo {
	
	public MembresiaVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MembresiaVo(Long id, int meses, String descripcion, double costo, Long usuario_crea, Long usuario_modifica,
			Date fecha_alta, Date fecha_modificacion, Integer activo) {
		super();
		this.id = id;
		this.meses = meses;
		this.descripcion = descripcion;
		this.costo = costo;
		this.usuario_crea = usuario_crea;
		this.usuario_modifica = usuario_modifica;
		this.fecha_alta = fecha_alta;
		this.fecha_modificacion = fecha_modificacion;
		this.activo = activo;
	}
	private Long id;
	private int meses;
	private String descripcion;
    private double costo;
    private Long usuario_crea;
    private Long usuario_modifica;
    private Date fecha_alta;
    private Date fecha_modificacion;
    private Integer activo;
 
}
