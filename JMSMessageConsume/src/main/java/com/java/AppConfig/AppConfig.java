package com.java.AppConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.java")
@Import({ MessagingConfiguration.class })
public class AppConfig
{

	
}
