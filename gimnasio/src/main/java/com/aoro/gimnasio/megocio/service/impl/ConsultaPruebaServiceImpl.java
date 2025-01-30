package com.aoro.gimnasio.megocio.service.impl;

import org.springframework.stereotype.Service;

import com.aoro.gimnasio.negocio.service.ConsultaPruebaService;

@Service
public class ConsultaPruebaServiceImpl implements ConsultaPruebaService{

	@Override
	public String prueba() {
		return "Consultas is working !!!!";
	}

}
