package com.aoro.gimnasio.negocio.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.negocio.dto.ResponseDto;
import com.aoro.gimnasio.negocio.service.impl.VentaServiceImpl;
import com.aoro.gimnasio.negocio.util.Constants;
import com.aoro.gimnasio.negocio.vo.ConsultaVentaVo;

@RestController
@RequestMapping("/venta/")
public class VentaController {
	Logger logger = Logger.getLogger(VentaController.class.getName());

	ResponseDto response;
	@Autowired
	private VentaServiceImpl ventaService;

	@PostMapping("/ventaDiaria")
	public ResponseDto ventaDiaria(@RequestBody ConsultaVentaVo conusltaVenta) {
		response = new ResponseDto();
		try {
			logger.info("Consulta venta diaria "+conusltaVenta.toString());
			
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(ventaService.detalleVentaDiaria(conusltaVenta));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	@PostMapping("/detalleVtaDiaria")
	public ResponseDto detalleVtaDiaria(@RequestBody ConsultaVentaVo conusltaVenta) {
		response = new ResponseDto();
		try {
			logger.info("Consulta detalle venta diaria "+conusltaVenta.toString());
			
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(ventaService.detalleVtaDiaria(conusltaVenta));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
}
