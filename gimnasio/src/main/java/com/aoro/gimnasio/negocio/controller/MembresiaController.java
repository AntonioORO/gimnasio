package com.aoro.gimnasio.negocio.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.negocio.dto.ResponseDto;
import com.aoro.gimnasio.negocio.entity.Membresia;
import com.aoro.gimnasio.negocio.service.impl.MembresiaServiceImpl;
import com.aoro.gimnasio.negocio.util.Constants;

@RestController
@RequestMapping("/membresias/")
public class MembresiaController {
	Logger logger = Logger.getLogger(MembresiaController.class.getName());

	@Autowired
	private MembresiaServiceImpl membresiaService;

	ResponseDto response;

	@GetMapping("/getAll")
	public ResponseDto getAll() {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(membresiaService.getAll());

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
			response.setData(membresiaService.getOne(id));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/saveUpdate")
	public ResponseDto save(@RequestBody Membresia catProd) {
		response = new ResponseDto();
		try {
			
			logger.info("Ingresa saveUpdate->"+catProd.toString());
			
			Membresia  catProdExist=membresiaService.findByMeses(catProd.getMeses());
			logger.info("catProdExist ->"+catProdExist);
			if(null!=catProdExist) {
				if(null==catProd.getId()) { //alta
					if(catProd.getMeses()==catProdExist.getMeses()) {
						response.setCodigo(Constants.COD_CONFLICT);
						response.setMessage(Constants.MSG_CONFLICT);
						return response;
					}
				}else {
					if(!catProd.getId().equals(catProdExist.getId())) {
						response.setCodigo(Constants.COD_CONFLICT);
						response.setMessage(Constants.MSG_CONFLICT);
						return response;
					}
				}
				
			}
			
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(membresiaService.saveUpdate(catProd));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/delete")
	public ResponseDto delete(@RequestBody Membresia catProd) {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(membresiaService.delete(catProd));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

}
