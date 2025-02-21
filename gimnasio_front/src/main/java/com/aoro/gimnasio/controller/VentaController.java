package com.aoro.gimnasio.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.auth.validator.InterceptorSesion;
import com.aoro.gimnasio.model.ConsultaVentaVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.service.VentaService;
@RestController
@RequestMapping("/venta/")

public class VentaController extends InterceptorSesion {
	Logger logger = Logger.getLogger(VentaController.class.getName());
	@Autowired
	private VentaService vtaService;
	
	@PostMapping("/ventaDiaria")
	public ResponseGenericDto ventaDiaria(@RequestBody ConsultaVentaVo ventaDiaria, Model model, HttpSession session) {
		logger.info("ventaDiaria " +ventaDiaria.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=vtaService.getVentaDiaria(ventaDiaria, session);
		}
		return resGenerica;

	}
	@PostMapping("/detalleVentaDiaria")
	public ResponseGenericDto detalleVentaDiaria(@RequestBody ConsultaVentaVo ventaDiaria, Model model, HttpSession session) {
		logger.info("detalleVentaDiaria " +ventaDiaria.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=vtaService.getDetalleVentaDiaria(ventaDiaria, session);
		}
		return resGenerica;

	}
}
