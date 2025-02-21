package com.aoro.gimnasio.negocio.service.impl;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoro.gimnasio.config.repository.DetalleVentaRepository;
import com.aoro.gimnasio.config.repository.VentaRepository;
import com.aoro.gimnasio.negocio.dto.ConsultaVentaDto;
import com.aoro.gimnasio.negocio.entity.Venta;
import com.aoro.gimnasio.negocio.vo.ConsultaVentaVo;

@Service
public class VentaServiceImpl {
	Logger logger = Logger.getLogger(VentaServiceImpl.class.getName());
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private DetalleVentaRepository detalleVentaRepository;
	
   
	private void vender(Venta vta) {
		Venta v=ventaRepository.save(vta);
		logger.info("Venta exitosa "+v.getId());
	}

	public ConsultaVentaDto detalleVentaDiaria(ConsultaVentaVo consulta) {
		ConsultaVentaDto consultaVenta=new ConsultaVentaDto();
		consultaVenta.setVentas(ventaRepository.findAllActives(consulta.getFecha()));
		Optional<String> m=ventaRepository.montoVentaDiario(consulta.getFecha());
		String monto="$ 0.0";
		if(null!=m&&m.isPresent()) {
			monto=m.get();
		}
		
		consultaVenta.setMonto(monto);
		return consultaVenta;
	}

	public Venta detalleVtaDiaria(ConsultaVentaVo conusltaVenta) {
		Venta v= ventaRepository.findById(conusltaVenta.getIdVenta()).get();
		v.setDetalleVenta(detalleVentaRepository.findProductos(conusltaVenta.getIdVenta()));
	  return v;
	}
}
