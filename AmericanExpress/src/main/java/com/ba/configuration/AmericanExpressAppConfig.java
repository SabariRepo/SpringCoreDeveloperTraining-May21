package com.ba.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.ba"})
@Import(value = {DBConfig.class})
//@EnableTransactionManagement
public class AmericanExpressAppConfig {

}
