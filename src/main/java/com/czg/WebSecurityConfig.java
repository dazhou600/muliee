package com.czg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.czg.filter.CaptcatFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// @Autowired
	// private CustomUserDetailsService customUserDetailsService;// code1
	@Autowired
	@Qualifier("dataSourcea")
	private DataSource dataSource; // code2

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin").hasAnyRole("WZADM").anyRequest().permitAll()
		.and().formLogin().loginPage("/login")
		.and().addFilterBefore(new CaptcatFilter("/login","/login?error"), UsernamePasswordAuthenticationFilter.class)
;

//		http.authorizeRequests()
//        .antMatchers("/home","/imgs/*.jpg","/fonts/**","/login_reg.html","/yzm.png*","/login").permitAll()
//        .anyRequest().authenticated()
//        .and().authorizeRequests().antMatchers("/admin").hasRole("admin_list")
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .defaultSuccessUrl("/admin")//登录成功后默认跳转到
//        .permitAll().failureUrl("/login?error")
//        .and().addFilterBefore(new CaptcatFilter("/login","/login?error"), UsernamePasswordAuthenticationFilter.class)
//        .logout()
//        .logoutSuccessUrl("/home");
//		
		
//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin().loginProcessingUrl("/login").loginPage("/login_reg").failureUrl("/login?error").and().
//		authorizeRequests().antMatchers("/imgs/*.jpg","/fonts/**","/login_reg").permitAll() // 其他地址的访问均需验证权限
//				.anyRequest().authenticated()
//				// 登录成功后可使用loginSuccessHandler()存储用户信息，可选。
//				// .successHandler(loginSuccessHandler())//code3 loginProcessingUrl("/login_reg").
//				.and().logout()
//				// 退出登录后的默认网址是”/home”
//				.logoutSuccessUrl("/home")
//				//
//				.permitAll().invalidateHttpSession(true).and()
//
//				// 登录后记住用户，下次自动登录
//				// 数据库中必须存在名为persistent_logins的表 //建表语句见code15
//				.rememberMe().tokenValiditySeconds(1209600)
//				// 指定记住登录信息所使用的数据源
//				.tokenRepository(tokenRepository());// code4
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT u_name , password , isactive FROM product.duty where u_name=? ")
		.authoritiesByUsernameQuery("SELECT distinct u.u_name uname, m.permission permission FROM duty u, menu m, role r, role_menu rm, user_role ur where u.u_name=? and u.u_id=ur.user_id and ur.role_id=r.r_id and r.r_id=rm.role_id and rm.menu_id=m.menu_id")
		//.groupAuthoritiesByUsername("SELECT r.r_id,r.data_operation,r.r_name FROM product.role r ,user_role ur ,duty d where d.u_name=? and d.u_id=ur.user_id and ur.role_id=r.r_id;")
		.passwordEncoder(new StandardPasswordEncoder("wztq"));
		//.and().authenticationProvider(getAuthenticationProvider());
	
		// 指定密码加密所使用的加密器为passwordEncoder() //需要将密码加密后写入数据库 //code13
		// auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());//
		// code5
		// //不删除凭据，以便记住用户
		// auth.eraseCredentials(false);
	}
	
	  @Bean
	    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver);
	        templateEngine.addDialect(new SpringSecurityDialect());
	        return templateEngine;
	    }
	
	private AuthenticationProvider getAuthenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setHideUserNotFoundExceptions(false);
		return provider;
		
	}

	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	public JdbcTokenRepositoryImpl tokenRepository() {
		JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
		j.setDataSource(dataSource);
		return j;
	}

//	@Bean
//	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
	// public LoginSuccessHandler loginSuccessHandler() {
	// return new LoginSuccessHandler();// code6 }
	// }
}
