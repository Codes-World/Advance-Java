package in.codesworld.aman.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.codesworld.aman.bean.Employee;
import in.codesworld.aman.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		//Starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Ask the container to give the bean with id as specified
		Employee employee = context.getBean("emp", Employee.class);
		System.out.println(employee);
		
		//close the container
		((AbstractApplicationContext) context).close();
	}
}
