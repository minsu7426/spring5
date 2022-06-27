package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Sub;

@Configuration
public class AppCtx {
	
	@Bean
	public Sub sub() {
		return new Sub();
	}
}
