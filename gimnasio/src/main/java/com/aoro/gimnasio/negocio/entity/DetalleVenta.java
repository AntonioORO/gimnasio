package com.aoro.gimnasio.negocio.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "detalle_venta")
@Builder
@Data
public class DetalleVenta {
	public DetalleVenta() {
		super();
	}
	public DetalleVenta(Long id, Long id_venta, String descripcion, double total, Integer estatus,
			Integer cantidad, double precio_unitario) {
		super();
		this.id = id;
		this.id_venta = id_venta;
		this.descripcion = descripcion;
		this.total = total;
		this.estatus = estatus;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_venta;
	private String descripcion;
	private double total;
	private Integer estatus;
	private Integer cantidad;
	private double precio_unitario;
}
