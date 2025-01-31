package com.aoro.gimnasio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aoro.gimnasio.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}