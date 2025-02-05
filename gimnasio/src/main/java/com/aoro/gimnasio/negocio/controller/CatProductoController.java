package com.aoro.gimnasio.negocio.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aoro.gimnasio.megocio.service.impl.CatalogoProductoServiceImpl;
import com.aoro.gimnasio.negocio.dto.ResponseDto;
import com.aoro.gimnasio.negocio.entity.CatProducto;
import com.aoro.gimnasio.negocio.util.Constants;

@RestController
@RequestMapping("/catproductos/")
public class CatProductoController {
	Logger logger = Logger.getLogger(CatProductoController.class.getName());

	@Autowired
	private CatalogoProductoServiceImpl catalogoProdService;

	ResponseDto response;

	@GetMapping("/getAll")
	public ResponseDto getAll() {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(catalogoProdService.getAll());

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
			response.setData(catalogoProdService.getOne(id));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/saveUpdate")
	public ResponseDto save(@RequestBody CatProducto catProd) {
		response = new ResponseDto();
		try {
			
			logger.info("Ingresa saveUpdate->"+catProd.toString());
			
			CatProducto  catProdExist=catalogoProdService.findByCodigoBarras(catProd.getCodigo_barras());
			logger.info("catProdExist ->"+catProdExist);
			if(null!=catProdExist) {
				if(null==catProd.getId()) { //alta
					if(catProd.getCodigo_barras().equals(catProdExist.getCodigo_barras())) {
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
			response.setData(catalogoProdService.saveUpdate(catProd));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/delete")
	public ResponseDto delete(@RequestBody CatProducto catProd) {
		response = new ResponseDto();
		try {
			response.setCodigo(Constants.COD_SUCCESS);
			response.setMessage(Constants.MSG_SUCCESS);
			response.setData(catalogoProdService.delete(catProd));

		} catch (Exception e) {
			response.setCodigo(Constants.COD_ERROR);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

}
