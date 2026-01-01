package in.codesworld.aman.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.codesworld.aman.bean.ICricketer;
import in.codesworld.aman.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		System.out.println("*****************Starting the container*****************");
		//Starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ICricketer cricketer = context.getBean(ICricketer.class);
		System.out.println("Implementation class object is :: "+cricketer.getClass().getName());
		System.out.println("Implementation class object is :: "+cricketer.getClass().getSuperclass());
		System.out.println("Implementation class object is :: "+Arrays.toString(cricketer.getClass().getDeclaredClasses()));
		cricketer.fielding();
		cricketer.bowling();
		cricketer.wicketkeeping();
		cricketer.batting();
		
		//close the container
		((AbstractApplicationContext) context).close();
		System.out.println("*****************Closing the container*****************");
	}
}
