package com.aoro.gimnasio.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aoro.gimnasio.auth.validator.UserValidator;
import com.aoro.gimnasio.model.User;
import com.aoro.gimnasio.service.UserService;
import com.aoro.gimnasio.vo.LoginVo;

@Controller
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class.getName());

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/iniciarSesion", method = RequestMethod.POST)
	public String iniciarSesion(@ModelAttribute("LoginVo") LoginVo userForm, BindingResult bindingResult, Model model) {

		logger.info("Iniciando sesion");
		logger.info("UserForm->" + userForm.toString());

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "login";
	}

}