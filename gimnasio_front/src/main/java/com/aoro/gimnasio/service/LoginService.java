package com.aoro.gimnasio.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.aoro.gimnasio.model.LoginVo;
import com.aoro.gimnasio.model.ResponseGenericDto;
import com.aoro.gimnasio.model.ResponseLoginVo;
import com.aoro.gimnasio.model.UserDetailsVo;
import com.aoro.gimnasio.repository.BackendRepository;
import com.aoro.gimnasio.utils.ArchivoToBase64;
import com.aoro.gimnasio.utils.Constants;
import com.google.gson.Gson;

@Service
public class LoginService {
	Logger logger = Logger.getLogger(LoginService.class.getName());

	@Autowired
	Gson gson;

	@Autowired
	private BackendRepository loginRepository;

	public void login(LoginVo user, HttpSession session, Model model) {
		ResponseGenericDto respuesta = loginRepository.callPost(user, null, Constants.URL_LOGIN);
		if (null != respuesta && respuesta.getCodigo() == 0) {
			String Json = gson.toJson(respuesta.getData());
			ResponseLoginVo auth = gson.fromJson(Json, ResponseLoginVo.class);
			try {
				String rutaArchivo = "C:/gimnasio_app/img/aoro.jpg";
		        String tipoArchivo =ArchivoToBase64.getTipoArchivo(rutaArchivo);
		        String base64 =ArchivoToBase64.archivoToBase64(rutaArchivo);
		    	auth.getUsuario().setImg("data:"+tipoArchivo+";base64,"+base64);
		       
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			session.setAttribute("logged", true);
			session.setAttribute("token", auth.getToken());
			session.setAttribute("user", auth.getUsuario());

		}
	}
	

}
