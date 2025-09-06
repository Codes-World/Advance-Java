package in.codesworld.aman.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "in.codesworld.aman")
public class AppConfig {
	static {
		System.out.println("AppConfig.class file is loading.....");
	}
	public AppConfig() {
		System.out.println("AppConfig object is created....");
	}
	
	@Bean(name = "ldt")
	public LocalDateTime dtObj() {
		return LocalDateTime.now();
	}
	
}
