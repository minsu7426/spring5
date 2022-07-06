package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.TimeAspect;
import spring.Calculator;
import spring.Division;
import spring.Minus;
import spring.Multiplication;
import spring.Plus;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {

	@Bean
	public TimeAspect timeAspect() {
		return new TimeAspect();
	}
	@Bean
	public Calculator plus() {
		return new Plus();
	}
	
	@Bean
	public Calculator minus() {
		return new Minus();
	}
	
	@Bean
	public Calculator division() {
		return new Division();
	}
	
	@Bean
	public Calculator multiplication() {
		return new Multiplication();
	}
	
}
