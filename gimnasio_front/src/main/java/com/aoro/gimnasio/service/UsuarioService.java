package com.aoro.gimnasio.service;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.aoro.gimnasio.model.MembresiaVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.model.UsuarioVo;
import com.aoro.gimnasio.repository.BackendRepository;
import com.aoro.gimnasio.utils.Constants;
import com.google.gson.Gson;

@Service
public class UsuarioService {
	Logger logger = Logger.getLogger(UsuarioService.class.getName());

	@Autowired
	Gson gson;

	@Autowired
	private BackendRepository usuarioRepository;

	public ResponseGenericDto getAll(HttpSession session) {
		String token = (String) session.getAttribute("token");
		return usuarioRepository.callGet(null, token, Constants.USUARIOS_GET_ALL	);

	}

	public ResponseGenericDto saveUpdate(MembresiaVo membresia, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.USUARIOS_SAVE_UPDATE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		membresia.setUsuario_crea(usuarioVo.getId());
		membresia.setUsuario_modifica(usuarioVo.getId());
		
		return usuarioRepository.callPost(membresia, token, Constants.USUARIOS_SAVE_UPDATE);

	}

	public ResponseGenericDto delete(MembresiaVo membresia, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.USUARIOS_DELETE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		membresia.setUsuario_modifica(usuarioVo.getId());
		return usuarioRepository.callPost(membresia, token, Constants.USUARIOS_DELETE);

	}

	public ResponseGenericDto getUserParaSocio(HttpSession session) {
		String token = (String) session.getAttribute("token");
		return usuarioRepository.callGet(null, token, Constants.USUARIOS_SOCIOS_GET_ALL);
	}

}
