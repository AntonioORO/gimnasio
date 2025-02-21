package com.aoro.gimnasio.negocio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "membresia")
@Builder
@Data

public class Membresia {
	
	
	public Membresia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Membresia(Long id, int meses, String descripcion, double costo, Integer usuario_crea,
			Integer usuario_modifica, Date fecha_alta, Date fecha_modificacion, Integer activo) {
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
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private int meses;
	private String descripcion;
    private double costo;
    private Integer usuario_crea;
    private Integer usuario_modifica;
    private Date fecha_alta;
    private Date fecha_modificacion;
    private Integer activo;
 
}
