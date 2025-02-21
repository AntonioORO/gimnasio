package com.aoro.gimnasio.negocio.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "venta")
@Builder
@Data
public class Venta {
	public Venta() {
		super();
	}
	public Venta(Long id, double importe, Date fecha_venta, Integer estatus, Usuario usuario_venta,
			List<DetalleVenta> detalleVenta) {
		super();
		this.id = id;
		this.importe = importe;
		this.fecha_venta = fecha_venta;
		this.estatus = estatus;
		this.usuario_venta = usuario_venta;
		this.detalleVenta = detalleVenta;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double importe;
	private Date fecha_venta;
	private Integer estatus;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "usuario_venta", referencedColumnName = "id")
	private Usuario usuario_venta;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "detalle_venta", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_venta"))
	private List<DetalleVenta> detalleVenta = new ArrayList();

}
