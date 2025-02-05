package com.aoro.gimnasio.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aoro.gimnasio.auth.validator.InterceptorSesion;
import com.aoro.gimnasio.model.LoginVo;
import com.aoro.gimnasio.service.LoginService;

@Controller
public class ViewsController extends InterceptorSesion {
	Logger logger = Logger.getLogger(ViewsController.class.getName());

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/cerrarSession", method = RequestMethod.GET)
	public String cerrarSession(@ModelAttribute("LoginVo") LoginVo user, Model model, HttpSession session) {
		logger.info("Cerrando session");
		
		session.setAttribute("logged", false);
		session.setAttribute("user", null);
		return "login";
				
	}

	@RequestMapping(value = { "", "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			return "welcome";
		}
		return "login";
	}
	@RequestMapping(value = { "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model, HttpSession session) {
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			return "welcome";
		}
		return "login";
	}
	@RequestMapping(value = { "/catalogoProductos"}, method = RequestMethod.GET)
	public String catalogoProductos(Model model, HttpSession session) {
		if (sesionActiva(session)) {
			logger.info("Sesion activa");
			return "catalogos/productos";
		}
		return "login";
	}


}