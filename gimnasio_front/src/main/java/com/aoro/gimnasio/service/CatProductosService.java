package com.aoro.gimnasio.service;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.aoro.gimnasio.model.CatProductoVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.model.UsuarioVo;
import com.aoro.gimnasio.repository.BackendRepository;
import com.aoro.gimnasio.utils.Constants;
import com.google.gson.Gson;

@Service
public class CatProductosService {
	Logger logger = Logger.getLogger(CatProductosService.class.getName());

	@Autowired
	Gson gson;

	@Autowired
	private BackendRepository loginRepository;

	public ResponseGenericDto getAll(HttpSession session) {
		String token = (String) session.getAttribute("token");
		return loginRepository.callGet(null, token, Constants.CAT_PRODUCTOS_GET_ALL);

	}

	public ResponseGenericDto saveUpdate(CatProductoVo catProd, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.CAT_PRODUCTOS_SAVE_UPDATE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		catProd.setUsuario_crea(usuarioVo.getId());
		catProd.setUsuario_modifica(usuarioVo.getId());
		
		return loginRepository.callPost(catProd, token, Constants.CAT_PRODUCTOS_SAVE_UPDATE);

	}

	public ResponseGenericDto delete(CatProductoVo producto, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.CAT_PRODUCTOS_DELETE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		producto.setUsuario_modifica(usuarioVo.getId());
		return loginRepository.callPost(producto, token, Constants.CAT_PRODUCTOS_DELETE);

	}

}
