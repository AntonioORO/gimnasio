package com.aoro.gimnasio.model;

import java.util.Date;

import lombok.Data;
@Data
public class CatProductoVo {

	public CatProductoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatProductoVo(Long id, String codigo_barras, String descripcion, double costo_compra, double costo_venta,
			Integer stock, Integer stock_minimo, Long usuario_modifica, Long usuario_crea, Date fecha_alta,
			Date fecha_modificacion, Integer activo) {
		super();
		this.id = id;
		this.codigo_barras = codigo_barras;
		this.descripcion = descripcion;
		this.costo_compra = costo_compra;
		this.costo_venta = costo_venta;
		this.stock = stock;
		this.stock_minimo = stock_minimo;
		this.usuario_modifica = usuario_modifica;
		this.usuario_crea = usuario_crea;
		this.fecha_alta = fecha_alta;
		this.fecha_modificacion = fecha_modificacion;
		this.activo = activo;
	}
	private Long id;
	private String codigo_barras;
	private String descripcion;
	private double costo_compra;
	private double costo_venta;
	private Integer stock;
	private Integer stock_minimo;
	private Long usuario_modifica;
	private Long usuario_crea;
	private Date fecha_alta;
	private Date fecha_modificacion;
	private Integer activo;

}
