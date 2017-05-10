package com.czg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

//@Component
public class CaptcatFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {		
		if(request.getAttribute("yzm")==null){
			new CaptcatException("验证码错误！") ;
		}
		System.out.println("@@@@@@@@@@@@@"+((HttpServletRequest)request).getSession().getAttribute("yzm"));
		if(request.getAttribute("yzm")==((HttpServletRequest)request).getSession().getAttribute("yzm")){
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
