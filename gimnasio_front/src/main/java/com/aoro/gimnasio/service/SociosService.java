package com.aoro.gimnasio.service;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.aoro.gimnasio.model.SocioVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.model.UsuarioVo;
import com.aoro.gimnasio.repository.BackendRepository;
import com.aoro.gimnasio.utils.Constants;
import com.google.gson.Gson;

@Service
public class SociosService {
	Logger logger = Logger.getLogger(SociosService.class.getName());

	@Autowired
	Gson gson;

	@Autowired
	private BackendRepository loginRepository;

	public ResponseGenericDto getAll(HttpSession session) {
		String token = (String) session.getAttribute("token");
		return loginRepository.callGet(null, token, Constants.SOCIOS_GET_ALL);

	}

	public ResponseGenericDto saveUpdate(SocioVo membresia, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.SOCIOS_SAVE_UPDATE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		UsuarioVo userCrea=new UsuarioVo();
		userCrea.setId(usuarioVo.getId());
		membresia.setUsuario_crea(usuarioVo.getId());
		membresia.setUsuario_modifica(usuarioVo.getId());
		
		return loginRepository.callPost(membresia, token, Constants.SOCIOS_SAVE_UPDATE);

	}

	public ResponseGenericDto delete(SocioVo membresia, HttpSession session, Model model) {
		logger.info("Enviando "+ Constants.SOCIOS_DELETE);
		String token = (String) session.getAttribute("token");
		UsuarioVo usuarioVo=(UsuarioVo) session.getAttribute("user");
		UsuarioVo userCrea=new UsuarioVo();
		userCrea.setId(usuarioVo.getId());
	    membresia.setUsuario_modifica(usuarioVo.getId());
		return loginRepository.callPost(membresia, token, Constants.SOCIOS_DELETE);

	}

	public ResponseGenericDto findByUserNames(SocioVo socioVo, HttpSession session, Model model) {
		logger.info("findByUserNames "+ Constants.SOCIOS_FIND_FIND_USERNAMES);
		String token = (String) session.getAttribute("token");
		return loginRepository.callPost(socioVo, token, Constants.SOCIOS_FIND_FIND_USERNAMES);
	}

}
