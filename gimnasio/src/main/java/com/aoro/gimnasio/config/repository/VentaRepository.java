package com.aoro.gimnasio.config.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aoro.gimnasio.negocio.entity.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

	@Query(value = 
			" select " + 
			"v.id as folio, " + 
			"CONCAT('$ ',FORMAT(v.importe,2)) as importe, " + 
			"date_format(fecha_venta,'%d/%m/%Y') as fecha, " + 
			"CONCAT(u.nombre,' ',u.apaterno,' ',u.amaterno) as usuario " + 
			"from venta v " + 
			"inner join usuario u on (v.usuario_venta=u.id) " + 
			"where " + 
			"v.estatus=1 " + 
			"and date_format(fecha_venta,'%Y-%m-%d')=:fecha "
					
			, nativeQuery = true)
	List<Map<String, Object>> findAllActives(@Param("fecha") String fecha);
	
	@Query(value = 
			" select " + 
			"CONCAT('$ ',FORMAT(sum(v.importe),2)) as importe " + 
			"from venta v " + 
			"inner join usuario u on (v.usuario_venta=u.id) where " + 
			"v.estatus=1 " + 
			"and date_format(fecha_venta,'%Y-%m-%d')=:fecha "
			, nativeQuery = true)
	Optional<String> montoVentaDiario(@Param("fecha") String fecha);
	
	
}
