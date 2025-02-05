package com.aoro.gimnasio.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aoro.gimnasio.negocio.entity.CatProducto;

@Repository
public interface CatalogoProductoRepository extends JpaRepository<CatProducto, Long> {

	@Query("select c from CatProducto c where c.activo =1")
	List<CatProducto> findAllActives();
	
	@Query("select c from CatProducto c where c.activo =1 and c.codigo_barras=:codigo ")
	CatProducto findByCodigoBarras(@Param("codigo") String codigo );
	

}
