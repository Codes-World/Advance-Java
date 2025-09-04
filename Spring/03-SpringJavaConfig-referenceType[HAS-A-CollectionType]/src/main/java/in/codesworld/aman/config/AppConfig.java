package in.codesworld.aman.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public Object wmgObj() {
		System.out.println("AppConfig.wmgObj() :: Creating the object...");
		
		//Creating Dependent Object
		List<String> friends = List.of("Aman", "Amit", "Manish");
		Set<String> numbers = Set.of("9374695759", "9374695755", "9374695754");
		Map<String, String> accountNumber = Map.of("canara", "12323", "SBI", "2333221");
		
		//Creating a Target Object
		Employee employee = new Employee(10, 23456.5f, friends, numbers, accountNumber);
		
		
		return employee;
	}
}
