package com.aoro.gimnasio.negocio.service.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.config.repository.UserRepository;
@Service
public class UsuarioServiceImpl {
	Logger logger = Logger.getLogger(UsuarioServiceImpl.class.getName());
	@Autowired
	private UserRepository userRepository;

	public 	List<Map<String, Object>> findUserSocios() {
		return userRepository.findUserSocios();
	}
}