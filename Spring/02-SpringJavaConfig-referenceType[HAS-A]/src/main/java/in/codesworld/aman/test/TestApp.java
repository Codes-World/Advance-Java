package in.codesworld.aman.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.codesworld.aman.bean.WishMessageGenerator;
import in.codesworld.aman.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		
		//Starting the container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Working with bean created by IOC
		WishMessageGenerator wmg = context.getBean("wmg", WishMessageGenerator.class);
		String status = wmg.wishMessage("Aman");
		System.out.println(status);
		
		//close the container
		((AbstractApplicationContext) context).close();
	}
}
