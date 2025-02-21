package com.aoro.gimnasio.config.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aoro.gimnasio.negocio.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	boolean existsByNick(String nick);

	Optional<Usuario> findByNick(String nick);

	@Query(value = "Select u.id, CONCAT(u.nombre , ' ', u.apaterno,' ',u.amaterno) as usuario from usuario u", nativeQuery = true)
	List<Map<String, Object>> findUserSocios();

}