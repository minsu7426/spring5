package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.WebController;
import t1.Dao;

@Configuration
public class ControllerConfig {
	
	@Bean
	public WebController webController() {
		return new WebController();
	}
	
	@Bean
	public Dao dao() {
		return new Dao();
	}
	
}
