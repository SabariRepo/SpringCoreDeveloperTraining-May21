package com.skillup;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;

@Configuration
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource = null;
		try {
			dataSource = (DataSource)jndiTemplate.lookup("java:jboss/datasources/MySqlDS");
		}catch(NamingException exception) {
			exception.printStackTrace();
		}	
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
}
