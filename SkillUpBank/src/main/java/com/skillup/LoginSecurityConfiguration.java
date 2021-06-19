package com.skillup;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//This Spring Configuration Class is meant for providing Security Configuration Code
@Configuration
@EnableWebSecurity
public class LoginSecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	DataSource dataSource;
	
	//Write code for configuring the endpoint mapped to roles
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/skillup/welcome").permitAll()
		.antMatchers("/skillup/developer").hasAnyRole("DEVELOPER","ADMIN")
		.antMatchers("/skillup/tester").hasAnyRole("TESTER","ADMIN")
		.antMatchers("/skillup/admin").hasRole("ADMIN")
		.and()
		//.httpBasic(); //Basic Authentication
		.formLogin();//.and().exceptionHandling(Class);// Default Form Based Authentication
		//.loginPage("/abc") // Custom Form Based Authentication
		//.defaultSuccessUrl("")
		//.failureUrl("")
		//.usernameParameter("user")
		//.passwordParameter("pass")
		//.and()
		//.logout().logoutSuccessUrl("");
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
		.passwordEncoder(bcryptPasswordEncoder)
		.dataSource(dataSource)
		.usersByUsernameQuery("select email,password,enabled from users where email = ?")
		.authoritiesByUsernameQuery("select email,authority from authorities where email = ?");
		
		
	}
	
	//1. In-Memory Authentication details
	//or
	//2. JDBC Authentication Details
	//@Override
	protected void configure1(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.passwordEncoder(bcryptPasswordEncoder)
		.withUser("sabari@gmail.com")
		//.password("{noop}sabari@123")
		.password("sabari@123")
		.roles("DEVELOPER")
		.and()
		.withUser("balaji@gmail.com")
		.password("$2y$12$9OjXgr7kgKaiKocq3at/dezk.YC1srjz0e1JkSYfeKknc9SQf.B8e") //encrypted password will be decrypted using bcryptPasswordEncoder instance 
		.roles("ADMIN")
		.and()
		.withUser("kishore@gmail.com")
		.password("kishore@123")
		.roles("TESTER")
		.and()
		.withUser("sundar@gmail.com")
		.password("sundar@123")
		.roles("TESTER")
		.and()
		.withUser("steve@gmail.com")
		.password("steve@123")
		.roles("DEVELOPER");
	}
}
