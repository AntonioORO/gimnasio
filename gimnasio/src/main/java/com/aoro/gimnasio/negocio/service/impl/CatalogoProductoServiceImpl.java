package com.aoro.gimnasio.negocio.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.config.repository.CatalogoProductoRepository;
import com.aoro.gimnasio.negocio.controller.CatProductoController;
import com.aoro.gimnasio.negocio.entity.CatProducto;

@Service
public class CatalogoProductoServiceImpl {
	Logger logger = Logger.getLogger(CatalogoProductoServiceImpl.class.getName());

	@Autowired
	private CatalogoProductoRepository catProdRepository;

	public List<CatProducto> getAll() {
		return catProdRepository.findAllActives();
	}

	public CatProducto getOne(Long id) {
		return catProdRepository.findById(id).get();
	}
	
	public CatProducto saveUpdate(CatProducto catProd) {
		catProd.setFecha_alta(new Date());
		catProd.setFecha_modificacion(new Date());
		catProd.setActivo(1);
		return catProdRepository.save(catProd);
	}

	public boolean delete(CatProducto catProd) {
		CatProducto cp=getOne(catProd.getId());
		
		logger.info("Delete->"+cp.toString());
		
		cp.setUsuario_modifica(catProd.getUsuario_modifica());
		cp.setActivo(0);
		logger.info("Send->"+cp);
		catProdRepository.save(cp);
		return true;
	}
	
	public CatProducto findByCodigoBarras(String codigo) {
		return catProdRepository.findByCodigoBarras(codigo);
	}
	
}
