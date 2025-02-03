package com.aoro.gimnasio.auth.validator;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

public class InterceptorSesion {
	Logger logger = Logger.getLogger(InterceptorSesion.class.getName());

	public boolean sesionActiva(HttpSession session) {
		
		logger.info("session logged-->"+session.getAttribute("logged"));
		if(null!=session&& null!=session.getAttribute("logged")) {
			if( session.getAttribute("logged").equals(true)) {
				return Boolean.TRUE;
			}else {
				return Boolean.FALSE;
			}
			
		}else {
			return Boolean.FALSE;
		}
	}
	
}
