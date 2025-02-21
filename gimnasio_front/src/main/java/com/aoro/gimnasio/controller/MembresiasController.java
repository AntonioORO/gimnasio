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
import com.aoro.gimnasio.model.MembresiaVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.service.MembresiasService;

@RestController
@RequestMapping("/catalogo/membresia/")
public class MembresiasController extends InterceptorSesion {
	Logger logger = Logger.getLogger(SesionController.class.getName());

	@Autowired
	private MembresiasService membresiaService;

	@GetMapping("/getAll")
	public ResponseGenericDto getAll(Model model, HttpSession session) {
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			return membresiaService.getAll(session);
		} 
		return resGenerica;

	}
	
	@PostMapping("/saveUpdate")
	public ResponseGenericDto saveUpdate(@RequestBody MembresiaVo membresia, Model model, HttpSession session) {
		logger.info("saveUpdate " +membresia.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=membresiaService.saveUpdate(membresia, session, model);
		}
		return resGenerica;

	}
	@PostMapping("/delete")
	public ResponseGenericDto delete(@RequestBody MembresiaVo membresia, Model model, HttpSession session) {
		logger.info("delete " +membresia.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=membresiaService.delete(membresia, session, model);
		}
		return resGenerica;

	}

}
