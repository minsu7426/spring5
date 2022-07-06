package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.WebController;
import dao.MemberDao;

@Configuration
public class AppCtx {

	@Bean
	public WebController webController() {
		return new WebController();
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
}
