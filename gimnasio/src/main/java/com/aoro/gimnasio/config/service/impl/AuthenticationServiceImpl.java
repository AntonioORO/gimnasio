package com.aoro.gimnasio.config.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.config.auth.JwtService;
import com.aoro.gimnasio.config.controller.request.AuthenticationRequest;
import com.aoro.gimnasio.config.controller.request.RegisterRequest;
import com.aoro.gimnasio.config.controller.response.AuthenticationResponse;
import com.aoro.gimnasio.config.repository.RoleRepository;
import com.aoro.gimnasio.config.repository.UserRepository;
import com.aoro.gimnasio.config.service.AuthenticationService;
import com.aoro.gimnasio.negocio.entity.Rol;
import com.aoro.gimnasio.negocio.entity.Usuario;

import io.jsonwebtoken.JwtBuilder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.existsByNick(request.getNick()))
            throw new RuntimeException("Nick is already in use");

        String password = passwordEncoder.encode(request.getPassword());
        Rol userRole = roleRepository.findById(request.getRol())
                .orElseThrow(() -> new RuntimeException("role does not exist"));
        Set<Rol> roles = new HashSet<>();
        roles.add(userRole);


        Usuario user = Usuario.builder()
                .activo(1)
                .amaterno(request.getAmaterno())
                .apaterno(request.getApaterno())
                .fecha_alta(new Date())
                .fecha_modificacion(new Date())
                .img_url(request.getImg_url())
                .intentos(0)
                .nick(request.getNick())
                .nombre(request.getNombre())
                .password(password)
                .roles(roles)
                .build();


        userRepository.save(user);

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getNick(),
                                request.getPassword()
                        )
                );
        JwtBuilder jwtBuilder = jwtService.generateToken(authentication);

        return AuthenticationResponse.builder()
                .token(jwtBuilder.compact())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getNick(),
                                request.getPassword()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtBuilder jwtBuilder = jwtService.generateToken(authentication);
        Date expiresAt =jwtService.extractExpiration(jwtBuilder.compact());
        return AuthenticationResponse.builder()
                .token(jwtBuilder.compact())
                .expired(expiresAt)
                .roles(authentication.getAuthorities())
                .build();
    }

	public AuthenticationResponse update(RegisterRequest request) {
	Optional<Usuario> usuario=userRepository.findByNick(request.getNick());
		
		 if (usuario.isPresent()&&usuario.get().getNick().equals(request.getNick())&&usuario.get().getId()!=request.getId())
	            throw new RuntimeException("Nick is already in use");

	        String password = passwordEncoder.encode(request.getPassword());
	        Rol userRole = roleRepository.findById(request.getRol())
	                .orElseThrow(() -> new RuntimeException("role does not exist"));
	        Set<Rol> roles = new HashSet<>();
	        roles.add(userRole);
	        Usuario user = Usuario.builder()
	        		.id(request.getId())
	                .activo(1)
	                .amaterno(request.getAmaterno())
	                .apaterno(request.getApaterno())
	                .fecha_alta(new Date())
	                .fecha_modificacion(new Date())
	                .img_url(request.getImg_url())
	                .intentos(0)
	                .nick(request.getNick())
	                .nombre(request.getNombre())
	                .password(password)
	                .roles(roles)
	                .build();


	        userRepository.save(user);

	        Authentication authentication =
	                authenticationManager.authenticate(
	                        new UsernamePasswordAuthenticationToken(
	                                request.getNick(),
	                                request.getPassword()
	                        )
	                );
	        JwtBuilder jwtBuilder = jwtService.generateToken(authentication);

	        return AuthenticationResponse.builder()
	                .token(jwtBuilder.compact())
	                .build();
	}

	public Usuario detalleUsuario(AuthenticationRequest request) {
		Optional<Usuario> optUser=userRepository.findByNick(request.getNick());
		Usuario u=optUser.get();
		u.getRoles().stream().forEach(rol -> u.setRol(rol.getNombre()));
		
		
	return u;
	}
	public boolean eliminar(RegisterRequest request) {
		Optional<Usuario> usuario=userRepository.findById(request.getId());
		Usuario ubaja=usuario.get();
		ubaja.setActivo(0);
		userRepository.save(ubaja);
		return true;
	}

}
