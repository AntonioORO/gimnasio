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
public class MembresiasService {
	Logger logger = Logger.getLogger(MembresiasService.class.getName());

	@Autowired
	Gson gson;

	@Autowired
	private BackendRepository loginRepository;

	public ResponseGenericDto getAll(HttpSession session) {
		String token = (String) session.getAttribute("token");
		return loginRepository.callGet(null, token, Constants.MEMBRESIAS_GET_ALL);

	}

	public ResponseGenericDto saveUpdate(MembresiaVo membresia, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.MEMBRESIAS_SAVE_UPDATE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		membresia.setUsuario_crea(usuarioVo.getId());
		membresia.setUsuario_modifica(usuarioVo.getId());
		
		return loginRepository.callPost(membresia, token, Constants.MEMBRESIAS_SAVE_UPDATE);

	}

	public ResponseGenericDto delete(MembresiaVo membresia, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.MEMBRESIAS_DELETE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		membresia.setUsuario_modifica(usuarioVo.getId());
		return loginRepository.callPost(membresia, token, Constants.MEMBRESIAS_DELETE);

	}

}
