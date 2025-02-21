package com.aoro.gimnasio.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.auth.validator.InterceptorSesion;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.service.UsuarioService;

@RestController
@RequestMapping("/catalogo/usuarios/")
public class UsuarioController extends InterceptorSesion {
	Logger logger = Logger.getLogger(UsuarioController.class.getName());

	@Autowired
	private UsuarioService sociosService;

	@GetMapping("/getUserParaSocio")
	public ResponseGenericDto getAll(Model model, HttpSession session) {
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			return sociosService.getUserParaSocio(session);
		} 
		return resGenerica;

	}
}
