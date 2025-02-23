package com.aoro.gimnasio.config.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aoro.gimnasio.negocio.entity.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
	
	@Query(value = 
			" SELECT  "+
					" s.id, "+
					" s.nombre, "+
					" s.apaterno, "+
					" s.amaterno, "+
					" DATE_FORMAT(s.fecha_nacimiento,'%d/%m/%Y') as fecha_nacimiento, "+
					" DATE_FORMAT(s.fecha_nacimiento,'%Y-%m-%d') as fecha_nacimiento_combo, "+
					" m.descripcion as desc_membresia, "+
					" m.id as id_membresia, "+
					" DATE_FORMAT(s.inicio_membresia,'%d/%m/%Y') as inicio_membresia, "+
					" DATE_FORMAT(s.inicio_membresia,'%Y-%m-%d') as inicio_membresia_combo, "+
					" DATE_FORMAT(DATE_ADD(s.inicio_membresia, interval m.meses month),'%d/%m/%Y') as fin_membresia, "+
					" um.nombre as usuario_modifica, "+
					" um.id as id_usuario_modifica, "+
					" ur.nombre as usuario_responsable, "+
					" ur.id as id_usuario_responsable, "+
					" DATE_FORMAT(s.fecha_modificacion,'%d-%m-%Y') as fecha_modificacion "+
					" FROM socios s "+
					" inner join membresia m on(s.id_membresia=m.id) "+
					" inner join usuario um on (um.id=s.usuario_modifica) "+
					" inner join usuario ur on (ur.id=s.usuario_responsable) "+
					" where s.activo=1 "
					
			, nativeQuery = true)
	List<Map<String, Object>> findAllActives();
	
	@Query("select s from Socio s where s.activo =1 and s.nombre=:nombre and s.apaterno=:apaterno and s.amaterno=:amaterno ")
	Socio findByNombreApaternoAmaterno(@Param("nombre") String nombre,@Param("apaterno") String apaterno,@Param("amaterno") String amaterno);

	@Query(value = 
	" SELECT  "+
			" s.id, "+
			" s.nombre, "+
			" s.apaterno, "+
			" s.amaterno, "+
			" DATE_FORMAT(s.fecha_nacimiento,'%d/%m/%Y') as fecha_nacimiento, "+
			" DATE_FORMAT(s.fecha_nacimiento,'%Y-%m-%d') as fecha_nacimiento_combo, "+
			" m.descripcion as desc_membresia, "+
			" m.id as id_membresia, "+
			" DATE_FORMAT(s.inicio_membresia,'%d/%m/%Y') as inicio_membresia, "+
			" DATE_FORMAT(s.inicio_membresia,'%Y-%m-%d') as inicio_membresia_combo, "+
			" DATE_FORMAT(DATE_ADD(s.inicio_membresia, interval m.meses month),'%d/%m/%Y') as fin_membresia, "+
			" um.nombre as usuario_modifica, "+
			" um.id as id_usuario_modifica, "+
			" ur.nombre as usuario_responsable, "+
			" ur.id as id_usuario_responsable, "+
			" DATE_FORMAT(s.fecha_modificacion,'%d-%m-%Y') as fecha_modificacion "+
			" FROM socios s "+
			" inner join membresia m on(s.id_membresia=m.id) "+
			" inner join usuario um on (um.id=s.usuario_modifica) "+
			" inner join usuario ur on (ur.id=s.usuario_responsable) "+
			" where s.activo=1 and s.nombre like '%:nombre%'  "
			
	, nativeQuery = true)
List<Map<String, Object>> findByUserNames(@Param("nombre")String nombre, @Param("apaterno")String apaterno, @Param("amaterno")String amaterno);

}
