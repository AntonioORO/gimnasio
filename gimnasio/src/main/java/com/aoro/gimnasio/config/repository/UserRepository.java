package com.aoro.gimnasio.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aoro.gimnasio.negocio.entity.Usuario;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    boolean existsByNick(String nick);

    Optional<Usuario> findByNick(String nick);

}