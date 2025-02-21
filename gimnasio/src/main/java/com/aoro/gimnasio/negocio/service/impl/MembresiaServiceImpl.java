package com.aoro.gimnasio.negocio.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.config.repository.MembresiaRepository;
import com.aoro.gimnasio.negocio.entity.Membresia;

@Service
public class MembresiaServiceImpl {
	Logger logger = Logger.getLogger(MembresiaServiceImpl.class.getName());

	@Autowired
	private MembresiaRepository membresiaRepository;

	public List<Membresia> getAll() {
		return membresiaRepository.findAllActives();
	}

	public Membresia getOne(Long id) {
		return membresiaRepository.findById(id).get();
	}
	
	public Membresia saveUpdate(Membresia catProd) {
		catProd.setFecha_alta(new Date());
		catProd.setFecha_modificacion(new Date());
		catProd.setActivo(1);
		return membresiaRepository.save(catProd);
	}

	public boolean delete(Membresia catProd) {
		Membresia cp=getOne(catProd.getId());
		logger.info("Delete->"+cp.toString());
		cp.setUsuario_modifica(catProd.getUsuario_modifica());
		cp.setActivo(0);
		logger.info("Send->"+cp);
		membresiaRepository.save(cp);
		return true;
	}
	
	public Membresia findByMeses(Integer meses) {
		return membresiaRepository.findByMeses(meses);
	}
}
