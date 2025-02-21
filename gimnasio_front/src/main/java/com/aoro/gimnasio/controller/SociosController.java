package com.aoro.gimnasio.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.auth.validator.InterceptorSesion;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.model.SocioVo;
import com.aoro.gimnasio.service.SociosService;

@RestController
@RequestMapping("/catalogo/socios/")
public class SociosController extends InterceptorSesion {
	Logger logger = Logger.getLogger(SesionController.class.getName());

	@Autowired
	private SociosService sociosService;

	@GetMapping("/getAll")
	public ResponseGenericDto getAll(Model model, HttpSession session) {
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			return sociosService.getAll(session);
		} 
		return resGenerica;

	}
	
	@PostMapping("/saveUpdate")
	public ResponseGenericDto saveUpdate(@RequestBody SocioVo socioVo, Model model, HttpSession session) {
		logger.info("saveUpdate " +socioVo.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=sociosService.saveUpdate(socioVo, session, model);
		}
		return resGenerica;

	}
	@PostMapping("/delete")
	public ResponseGenericDto delete(@RequestBody SocioVo socioVo, Model model, HttpSession session) {
		logger.info("delete " +socioVo.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=sociosService.delete(socioVo, session, model);
		}
		return resGenerica;

	}

}
