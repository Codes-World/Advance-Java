package in.codesworld.aman.bean;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Filpkart {
	
	@Autowired
	@Qualifier("ekart")
	private ICourier courier;
	
	static {
		System.out.println("Filpkart.class file is loading.....");	
	}
	
	public Filpkart() {
		System.out.println("Filpkart object is created....");
	}
	
	public String shopping(String[] items, float[] prices) {
		System.out.println("Filpkart.shopping()");
		
		//calculating the total amount to be billed
		float billamount = 0.0f;
		for(float cost : prices) {
			billamount += cost;
		}
		
		String msg = courier.deliver(new Random().nextInt(1000));
		
		return Arrays.toString(items) + " with prices " + Arrays.toString(prices)+" having billamount :: "+billamount+ " :: "+msg;
	}
}
