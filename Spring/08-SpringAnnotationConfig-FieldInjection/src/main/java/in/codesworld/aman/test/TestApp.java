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
		
		//Asking container to give the bean
		Filpkart filpkart = context.getBean("filpkart", Filpkart.class);
		String status = filpkart.shopping(new String[] {"fossilwatch", "lpbelts", "arrowshoes"}, new float[] {5670.5f, 3500.5f, 4500.50f});
		System.out.println(status);
		//close the container
		((AbstractApplicationContext) context).close();
	}
}
