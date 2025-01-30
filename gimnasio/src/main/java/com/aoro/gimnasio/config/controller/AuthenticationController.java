package com.aoro.gimnasio.config.controller;

import com.aoro.gimnasio.config.controller.request.AuthenticationRequest;
import com.aoro.gimnasio.config.controller.request.RegisterRequest;
import com.aoro.gimnasio.config.controller.response.AuthenticationResponse;
import com.aoro.gimnasio.config.service.impl.AuthenticationServiceImpl;
import com.aoro.gimnasio.negocio.dto.ResponseDto;
import com.aoro.gimnasio.negocio.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	private ResponseDto response;

	@Autowired
	AuthenticationServiceImpl userServiceImpl;

	@PostMapping("/registrar")
	public ResponseEntity<ResponseDto> register(@RequestBody RegisterRequest request) {
		response = new ResponseDto();
		try {
			AuthenticationResponse  autresp=userServiceImpl.register(request);
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(autresp);

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(Constants.MSG_ERROR);
			e.printStackTrace();
		}
		return ResponseEntity.ok(response);
	}
	@PostMapping("/actualizar")
	public ResponseEntity<ResponseDto> actualizar(@RequestBody RegisterRequest request) {
		response = new ResponseDto();
		try {
			AuthenticationResponse  autresp=userServiceImpl.update(request);
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(autresp);

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(Constants.MSG_ERROR);
			e.printStackTrace();
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/eliminar")
	public ResponseEntity<ResponseDto> eliminar(@RequestBody RegisterRequest request) {
		response = new ResponseDto();
		try {
			boolean  autresp=userServiceImpl.eliminar(request);
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(autresp);

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(Constants.MSG_ERROR);
			e.printStackTrace();
		}
		return ResponseEntity.ok(response);
	}
	

	
}
