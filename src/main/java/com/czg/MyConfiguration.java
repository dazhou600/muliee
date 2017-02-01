package com.czg;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration 
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class }) 
public class MyConfiguration {
	@Bean
	public DataSource dataSource1() {
		org.springframework.jdbc.datasource.DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/product?characterEncoding=gbk&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("123456");
		return ds;
	}
}
