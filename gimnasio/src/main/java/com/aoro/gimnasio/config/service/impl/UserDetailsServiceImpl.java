package com.aoro.gimnasio.config.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.config.repository.UserRepository;
import com.aoro.gimnasio.negocio.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByNick(nick);
		if (!user.isPresent())
			throw new UsernameNotFoundException("the user not exists");
		return user.get();
	}
}