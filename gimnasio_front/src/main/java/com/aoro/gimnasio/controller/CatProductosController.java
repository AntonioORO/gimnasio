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
import com.aoro.gimnasio.model.CatProductoVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.service.CatProductosService;

@RestController
@RequestMapping("/catalogo/producto/")
public class CatProductosController extends InterceptorSesion {
	Logger logger = Logger.getLogger(SesionController.class.getName());

	@Autowired
	private CatProductosService catProdService;

	@GetMapping("/getAll")
	public ResponseGenericDto getAll(Model model, HttpSession session) {
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			return catProdService.getAll(session);
		} 
		return resGenerica;

	}
	
	@PostMapping("/saveUpdate")
	public ResponseGenericDto saveUpdate(@RequestBody CatProductoVo producto, Model model, HttpSession session) {
		logger.info("saveUpdate " +producto.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=catProdService.saveUpdate(producto, session, model);
		}
		return resGenerica;

	}
	@PostMapping("/delete")
	public ResponseGenericDto delete(@RequestBody CatProductoVo producto, Model model, HttpSession session) {
		logger.info("delete " +producto.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=catProdService.delete(producto, session, model);
		}
		return resGenerica;

	}
	@PostMapping("/getByCode")
	public ResponseGenericDto getByCode(@RequestBody CatProductoVo producto, Model model, HttpSession session) {
		logger.info("delete " +producto.toString());
		ResponseGenericDto resGenerica = new ResponseGenericDto();
		resGenerica.setCodigo(-1);
		if (sesionActiva(session)) {
			resGenerica=catProdService.getByCodigo(producto, session, model);
		}
		return resGenerica;

	}
	
	

}
