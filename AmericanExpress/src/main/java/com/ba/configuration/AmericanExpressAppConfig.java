package com.ba.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.ba"})
@Import(value = {DBConfig.class})
public class AmericanExpressAppConfig {

}
