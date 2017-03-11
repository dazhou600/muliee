package com.czg.admin.domain;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//@AutoConfigurationPackage
public class Config {
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        //entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
       // entityManagerFactoryBean
       //         .setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
       // entityManagerFactoryBean.setJpaProperties(hibProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.czg.admin.domain");
        return entityManagerFactoryBean;
    }
	
	private JpaVendorAdapter getJpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		//adapter.setDatabase("MYSQL");
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		//adapter.setDatabasePlatform("org.hibernate.dialact.HSQLDialect");Dialect MySQL5Dialect
 		adapter.getPersistenceProvider();
		adapter.setDatabasePlatform("org.hibernate.dialact.Dialect");
		return adapter;
		
	}
	private DataSource dataSource() {
		org.springframework.jdbc.datasource.DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/product?characterEncoding=gbk&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("123456");
		return ds;
	}
}
