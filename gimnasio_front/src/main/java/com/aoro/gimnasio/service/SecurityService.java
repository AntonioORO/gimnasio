package com.aoro.gimnasio.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}