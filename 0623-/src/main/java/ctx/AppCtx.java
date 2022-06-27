package ctx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mvc.Map;

@Configuration
public class AppCtx {
	
	@Bean
	public Map map() {
		return new Map();
	}
}
