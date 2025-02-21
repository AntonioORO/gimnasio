package com.aoro.gimnasio.service;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.model.ConsultaVentaVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.repository.BackendRepository;
import com.aoro.gimnasio.utils.Constants;
import com.google.gson.Gson;

@Service
public class VentaService {
	Logger logger = Logger.getLogger(VentaService.class.getName());

	@Autowired
	Gson gson;

	@Autowired
	private BackendRepository backendRepository;
	
	public ResponseGenericDto getVentaDiaria( ConsultaVentaVo consulta,HttpSession session) {
		String token = (String) session.getAttribute("token");
		return backendRepository.callPost(consulta, token, Constants.VENTA_GET_DIARIA);

	}

	public ResponseGenericDto getDetalleVentaDiaria(ConsultaVentaVo ventaDiaria, HttpSession session) {
		String token = (String) session.getAttribute("token");
		return backendRepository.callPost(ventaDiaria, token, Constants.VENTA_GET_DETALLE_DIARIA);

	}

}
