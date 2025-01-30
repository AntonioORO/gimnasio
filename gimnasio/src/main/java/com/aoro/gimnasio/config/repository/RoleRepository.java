package com.aoro.gimnasio.config.repository;

import com.aoro.gimnasio.config.model.enums.RoleEnum;
import com.aoro.gimnasio.negocio.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNombre(RoleEnum name);
}
