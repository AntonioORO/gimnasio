package com.aoro.gimnasio.negocio.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Builder
@Data

public class Usuario implements UserDetails {
	
    public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long id, String nombre, String apaterno, String amaterno, String password, String nick,
			Integer intentos, Date fecha_alta, Date fecha_modificacion, String img_url, Integer activo,
			Set<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.password = password;
		this.nick = nick;
		this.intentos = intentos;
		this.fecha_alta = fecha_alta;
		this.fecha_modificacion = fecha_modificacion;
		this.img_url = img_url;
		this.activo = activo;
		this.roles = roles;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String password;
    private String nick;
    private Integer intentos;
    private Date fecha_alta;
    private Date fecha_modificacion;
    private String img_url;
    private Integer activo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Rol> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre().toString())
                ).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return nick;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
