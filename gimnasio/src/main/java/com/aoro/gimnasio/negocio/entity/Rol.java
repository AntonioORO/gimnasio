package com.aoro.gimnasio.negocio.entity;

import lombok.*;

import javax.persistence.*;

import com.aoro.gimnasio.config.model.enums.RoleEnum;

@Entity(name="rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private Integer activo;
    

}
