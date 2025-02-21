package com.aoro.gimnasio.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aoro.gimnasio.negocio.entity.DetalleVenta;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long>{
	
	@Query("select d from DetalleVenta d where d.estatus =1 and d.id_venta=:idVenta ")
	List<DetalleVenta> findProductos(@Param("idVenta") Long idVenta);

}
