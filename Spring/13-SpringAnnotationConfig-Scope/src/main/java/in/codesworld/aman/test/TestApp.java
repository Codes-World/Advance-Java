package in.codesworld.aman.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.codesworld.aman.bean.Filpkart;
import in.codesworld.aman.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		//Starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("BeanNames are :: "+Arrays.toString(context.getBeanDefinitionNames()));
		
		Filpkart filpkart = context.getBean("filpkart", Filpkart.class);
		System.out.println(filpkart);
		
		//close the container
		((AbstractApplicationContext) context).close();
	}
}
