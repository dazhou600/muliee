package com.czg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// @Autowired
	// private CustomUserDetailsService customUserDetailsService;// code1
	@Autowired
	@Qualifier("dataSourcea")
	private DataSource dataSource; // code2

	@Override
	protected void configure(HttpSecurity http) throws Exception { // 允许所有用户访问”/”和”/home”

		http.authorizeRequests()
        .antMatchers("/imgs/*.jpg","/fonts/**","/login_reg.html").permitAll()
        //其他地址的访问均需验证权限
        .anyRequest().authenticated()
        .and()
        .formLogin()
        //指定登录页是"/login"
        .loginPage("/login")
        .defaultSuccessUrl("/admin")//登录成功后默认跳转到
        .permitAll()
        .and()
        .logout()
        .logoutSuccessUrl("/home")//退出登录后的默认url是"/home"
        .permitAll();
		
		
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

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT u_name , password , isactive FROM product.duty where u_name=? ")
		.authoritiesByUsernameQuery("SELECT distinct u.u_name uname, m.permission permission FROM duty u, menu m, role r, role_menu rm, user_role ur where u.u_name=? and u.u_id=ur.user_id and ur.role_id=r.r_id and r.r_id=rm.role_id and rm.menu_id=m.menu_id")
		.passwordEncoder(new StandardPasswordEncoder("wztq"));
	
		// 指定密码加密所使用的加密器为passwordEncoder() //需要将密码加密后写入数据库 //code13
		// auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());//
		// code5
		// //不删除凭据，以便记住用户
		// auth.eraseCredentials(false);
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
