package com.ba.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement //Enables Spring's annotation-driven transaction management capability,
public class DBConfig {

	// Start configuring the Data Source Information

	@Value("${datasource.username}") // SpeL -> Spring Expression Language
	String userName;

	@Value("${datasource.password}")
	String password;

	@Value("${datasource.url}")
	String url;

	@Value("${datasource.driver-class-name}")
	String drivername;

	// manually Configuring the Datasource and leaving it to the IoC container to
	// manage the instance
	// and wiring as necessity
	@Bean
	public DataSource dataSource() {

		DataSource dataSource = new DataSource();
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(drivername);

		return dataSource;

	}

	// Create the SpringJDBCTemplate and wire the Datasource into this JDBCTemplate

	@Bean
	public JdbcTemplate jdbcTemplate() {
		// Cookup the Object of JDBCTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource()); // Manual Wiring -> Constructor based wiring

		return jdbcTemplate;
	}
	//sNo qualifying bean of type 'org.springframework.transaction.TransactionManager' available
	//First Step: To Create Transaction Manager using DataSourceTransactionManager
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();

		dataSourceTransactionManager.setDataSource(dataSource());

		return dataSourceTransactionManager;
	}

	//Second Step: To Create the TransactionTemplate
	
	//Template class that simplifies programmatic transaction demarcation and transaction exception handling.
	/*@Bean 
	public TransactionTemplate transactionTemplate() {
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(dataSourceTransactionManager()); //Constructor based injection/wiring
	
		return transactionTemplate;
	
	}*/
	
}
