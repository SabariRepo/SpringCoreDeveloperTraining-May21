package com.ba.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfig {

	//Start configuring the Data Source Information
	
	@Value("${datasource.username}") //SpeL -> Spring Expression Language
	String userName;
	
	@Value("${datasource.password}")
	String password;
	
	@Value("${datasource.url}")
	String url;
	
	@Value("${datasource.driver-class-name}")
	String drivername;
	
	//manually Configuring the Datasource and leaving it to the IoC container to manage the instance
	//and wiring as necessity
	@Bean
	public DataSource dataSource() {
		
		DataSource dataSource = new DataSource();
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(drivername);
		
		return dataSource;
		
	}
	
	//Create the SpringJDBCTemplate and wire the Datasource into this JDBCTemplate
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		//Cookup the Object of JDBCTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource()); //Manual Wiring -> Constructor based wiring
		
		return jdbcTemplate;
	}
	
}
