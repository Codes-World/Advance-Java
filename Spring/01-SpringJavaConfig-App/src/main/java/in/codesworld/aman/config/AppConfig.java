package in.codesworld.aman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.codesworld.aman.bean.Employee;

@Configuration
public class AppConfig {
	static {
		System.out.println("AppConfig.class file is loading.....");
	}
	public AppConfig() {
		System.out.println("AppConfig object is created....");
	}
	
	@Bean(name="emp")
	public Employee empObj() {
		Employee emp = new Employee();
		emp.setEid(1001);
		emp.setEname("Aman");
		emp.setEage(23);
		emp.setEaadress("Hajipur");
		return emp;
	}
}
