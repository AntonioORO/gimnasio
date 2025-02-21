package com.aoro.gimnasio.negocio.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.negocio.dto.ResponseDto;
import com.aoro.gimnasio.negocio.service.impl.UsuarioServiceImpl;
import com.aoro.gimnasio.negocio.util.Constants;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioController {
	Logger logger = Logger.getLogger(UsuarioController.class.getName());

	ResponseDto response;
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping("/getUserParaSocio")
	public ResponseDto getAll() {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(usuarioService.findUserSocios());

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

}
