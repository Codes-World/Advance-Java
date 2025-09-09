package in.codesworld.aman.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.codesworld.aman.bean.Filpkart;
import in.codesworld.aman.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		//Starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] definitionNames = context.getBeanDefinitionNames();
		for(String beanName : definitionNames) {
			System.out.println(beanName);
		}
		
		Filpkart filpkart = context.getBean("filpkart", Filpkart.class);
		System.out.println(filpkart);
		
		//close the container
		((AbstractApplicationContext) context).close();
	}
}
