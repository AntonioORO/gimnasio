package com.aoro.gimnasio.negocio.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.config.repository.DetalleVentaRepository;
import com.aoro.gimnasio.config.repository.MembresiaRepository;
import com.aoro.gimnasio.config.repository.SocioRepository;
import com.aoro.gimnasio.config.repository.VentaRepository;
import com.aoro.gimnasio.negocio.entity.DetalleVenta;
import com.aoro.gimnasio.negocio.entity.Membresia;
import com.aoro.gimnasio.negocio.entity.Socio;
import com.aoro.gimnasio.negocio.entity.Usuario;
import com.aoro.gimnasio.negocio.entity.Venta;
@Service
public class SocioServiceImpl {
	Logger logger = Logger.getLogger(SocioServiceImpl.class.getName());

	@Autowired
	private SocioRepository socioRepository;
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private DetalleVentaRepository detVentaRepository;
	@Autowired
	private MembresiaRepository membresiaRepository;

	
	public 	List<Map<String, Object>> getAll() {
		List<Map<String, Object>> res= socioRepository.findAllActives();
		logger.info(res.toString());
		return res;
	}

	public Socio getOne(Long id) {
		return socioRepository.findById(id).get();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public Socio saveUpdate(Socio socio) {
		socio.setNombre(socio.getNombre().toUpperCase());
		socio.setApaterno(socio.getApaterno().toUpperCase());
		socio.setAmaterno(socio.getAmaterno().toUpperCase());
		socio.setFecha_alta(new Date());
		socio.setFecha_modificacion(new Date());
		socio.setActivo(1);
	    
		if(null==socio.getId()||socio.getId()==0) {
			Venta v=new Venta();
			v.setEstatus(1);
			v.setFecha_venta(new Date());
			v.setImporte(socio.getMembresia().getCosto());
			Usuario uv=new Usuario();
			uv.setId(socio.getUsuario_crea());
			v.setUsuario_venta(uv);
			v=ventaRepository.save(v);
			
			
			Optional<Membresia> m=membresiaRepository.findById(socio.getMembresia().getId());
			
			DetalleVenta dv=new DetalleVenta();
			dv.setCantidad(1);
			dv.setDescripcion("Membresia "+m.get().getDescripcion());
			dv.setEstatus(1);
			dv.setId_venta(v.getId());
			dv.setTotal(socio.getMembresia().getCosto());
			dv.setPrecio_unitario(socio.getMembresia().getCosto());
			
			detVentaRepository.save(dv);
		}
		return socioRepository.save(socio);
	}

	public boolean delete(Socio catProd) {
		Socio cp=getOne(catProd.getId());
		logger.info("Delete->"+cp.toString());
		cp.setUsuario_modifica(catProd.getUsuario_modifica());
		cp.setActivo(0);
		logger.info("Send->"+cp);
		socioRepository.save(cp);
		return true;
	}
	
	public Socio findByNombreApaternoAmaterno(Socio socio) {
		socio.setNombre(socio.getNombre().toUpperCase());
		socio.setApaterno(socio.getApaterno().toUpperCase());
		socio.setAmaterno(socio.getAmaterno().toUpperCase());
		return socioRepository.findByNombreApaternoAmaterno(socio.getNombre(),socio.getAmaterno(),socio.getApaterno());
	}

}
