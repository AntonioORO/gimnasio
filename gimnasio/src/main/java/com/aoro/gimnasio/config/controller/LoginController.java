package com.aoro.gimnasio.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.config.controller.request.AuthenticationRequest;
import com.aoro.gimnasio.config.controller.response.AuthenticationResponse;
import com.aoro.gimnasio.config.service.impl.AuthenticationServiceImpl;
import com.aoro.gimnasio.negocio.dto.ResponseDto;
import com.aoro.gimnasio.negocio.util.Constants;

@RestController

public class LoginController {
	
	private ResponseDto response;

	@Autowired
	AuthenticationServiceImpl userServiceImpl;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDto> authenticate(@RequestBody AuthenticationRequest request) {
		response = new ResponseDto();
		AuthenticationResponse responseAuth;

		try {
			responseAuth = userServiceImpl.authenticate(request);
			responseAuth.setUsuario(userServiceImpl.detalleUsuario(request));
			
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(responseAuth);

		} 
		catch (BadCredentialsException e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(Constants.MSG_BADCREDENTIALS);
		}
		catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(Constants.MSG_ERROR);
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(response);
	}
}
