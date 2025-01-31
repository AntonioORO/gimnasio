package com.aoro.gimnasio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aoro.gimnasio.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNick(String username);
}