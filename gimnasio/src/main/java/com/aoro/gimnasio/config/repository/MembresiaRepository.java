package com.aoro.gimnasio.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aoro.gimnasio.negocio.entity.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
	@Query("select m from Membresia m where m.activo =1")
	List<Membresia> findAllActives();

	@Query("select m from Membresia m where m.activo =1 and m.meses=:meses ")
	Membresia findByMeses(Integer meses);

}
