package com.aoro.gimnasio.negocio.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.negocio.dto.ResponseDto;
import com.aoro.gimnasio.negocio.entity.Socio;
import com.aoro.gimnasio.negocio.service.impl.SocioServiceImpl;
import com.aoro.gimnasio.negocio.util.Constants;

@RestController
@RequestMapping("/socios/")
public class SocioController {
	Logger logger = Logger.getLogger(SocioController.class.getName());

	@Autowired
	private SocioServiceImpl socioServiceImpl;

	ResponseDto response;

	@GetMapping("/getAll")
	public ResponseDto getAll() {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(socioServiceImpl.getAll());

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping("/getOne")
	public ResponseDto getOne(@RequestParam(name = "id") Long id) {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(socioServiceImpl.getOne(id));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/saveUpdate")
	public ResponseDto save(@RequestBody Socio socio) {
		response = new ResponseDto();
		try {
			
			logger.info("Ingresa saveUpdate->"+socio.toString());
			
			Socio  socioEx=socioServiceImpl.findByNombreApaternoAmaterno(socio);
			logger.info("socioExist ->"+socioEx);
			if(null!=socioEx) {
				if(null==socio.getId()) { //alta
					if(socio.getApaterno().toUpperCase().equals(socioEx.getApaterno().toUpperCase())||
							socio.getAmaterno().toUpperCase().equals(socioEx.getAmaterno().toUpperCase())||
							socio.getNombre().toUpperCase().equals(socioEx.getNombre().toUpperCase())
							) {
						response.setCodigo(Constants.COD_CONFLICT);
						response.setMessage(Constants.MSG_CONFLICT);
						return response;
					}
				}else {
					if(!socio.getId().equals(socioEx.getId())) {
						response.setCodigo(Constants.COD_CONFLICT);
						response.setMessage(Constants.MSG_CONFLICT);
						return response;
					}
				}
				
			}
			
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(socioServiceImpl.saveUpdate(socio));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/delete")
	public ResponseDto delete(@RequestBody Socio socio) {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(socioServiceImpl.delete(socio));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/findByUserNames")
	public ResponseDto findByUserNames(@RequestBody Socio socio) {
		response = new ResponseDto();
		try {
			
			logger.info("Ingresa findByUserName->"+socio.toString());
			
			List<Map<String, Object>>  listaSocios=socioServiceImpl.findByUserNames(socio);
			logger.info("listaSocios ->"+listaSocios);
			
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(listaSocios);

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}


}
