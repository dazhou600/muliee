package com.czg.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

@Configuration
public class CaptcatFilterConfig {

	@Bean
	public FilterRegistrationBean filterDemo3Registration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(getCaptcatFilter());
		registration.setUrlPatterns(Arrays.asList(new String[]{"/login"}));
		//registration.addInitParameter("paramName", "paramValue");
		registration.setName("yzmFilter");
		registration.setOrder(2);
		return registration;
	}

	@Bean
	public Filter getCaptcatFilter() {
		return new CaptcatFilter();
	}

	public void onStartup(ServletContext servletContext) {
		// TODO Auto-generated method stub
		System.out.println("************initia******************");
		FilterRegistration.Dynamic filter = servletContext.addFilter("yzmFilter", new CaptcatFilter());
		filter.addMappingForUrlPatterns(
				EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/login");
	}

}
