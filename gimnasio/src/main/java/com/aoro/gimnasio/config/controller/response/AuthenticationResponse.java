package com.aoro.gimnasio.config.controller.response;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import com.aoro.gimnasio.negocio.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
    private Date expired;
    private Collection<? extends GrantedAuthority> roles;
    private String rol;
    private Usuario usuario;
    
}
