package com.aoro.gimnasio.negocio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.negocio.service.ConsultaPruebaService;

@RestController
@RequestMapping("/consultas/prueba")
public class ConsultaPruebaController {

	@Autowired
	private ConsultaPruebaService consultaPruebaService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/test")
  
    public ResponseEntity<String> allUsers() {
        return ResponseEntity.ok(consultaPruebaService.prueba());
    }

}
