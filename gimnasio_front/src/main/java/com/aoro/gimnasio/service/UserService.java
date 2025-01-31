package com.aoro.gimnasio.service;

import com.aoro.gimnasio.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}