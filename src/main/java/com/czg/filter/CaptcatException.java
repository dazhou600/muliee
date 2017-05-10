package com.czg.filter;

import org.springframework.security.authentication.AuthenticationServiceException;


public class CaptcatException extends AuthenticationServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaptcatException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
