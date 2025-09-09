package in.codesworld.aman.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.codesworld.aman.config.AppConfig;
import in.codesworld.aman.dao.EmployeeMySQLDaoImpl;

public class TestApp {
	public static void main(String[] args) {
		
		//Starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] definitionNames = context.getBeanDefinitionNames();
		for(String beanName : definitionNames) {
			System.out.println(beanName);
		}
		
		EmployeeMySQLDaoImpl daoImpl = context.getBean("mysqlDao", EmployeeMySQLDaoImpl.class);
//		System.out.println(daoImpl);
		daoImpl.getConnection();
		
		//close the container
		((AbstractApplicationContext) context).close();
	}
}
