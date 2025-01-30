package com.aoro.gimnasio.config.auth;

import org.springframework.http.HttpStatus;

public class OnlineStoreAPIException  extends RuntimeException{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	 private String message;

	 public OnlineStoreAPIException(HttpStatus status, String message) {
	     this.status = status;
	     this.message = message;
	 }

	 public OnlineStoreAPIException(String message, HttpStatus status, String message1){
	     super(message);
	     this.status = status;
	     this.message = message1;
	 }

	 public HttpStatus getStatus() {
	     return status;
	 }

	@Override
	public String getMessage() {
	     return message;
	}
}