package com.aoro.gimnasio.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.auth.validator.InterceptorSesion;
import com.aoro.gimnasio.model.LoginVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.service.LoginService;

@RestController
public class SesionController extends InterceptorSesion {
	Logger logger = Logger.getLogger(SesionController.class.getName());

	@Autowired
	private LoginService loginService;

	@PostMapping("/iniciarSesion")
	public ResponseGenericDto iniciarSesion(@RequestBody LoginVo user, Model model, HttpSession session) {

		ResponseGenericDto resGenerica = new ResponseGenericDto();

		resGenerica.setCodigo(1);
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			resGenerica.setCodigo(0);
			return resGenerica;
		} else {
			logger.info("Iniciando sesion " + session.getAttribute("logged"));
			loginService.login(user, session, model);

			if (sesionActiva(session)) {
				resGenerica.setCodigo(0);
				logger.info("Sesion activa");
				return resGenerica;
			}
		}
		return resGenerica;

	}

}