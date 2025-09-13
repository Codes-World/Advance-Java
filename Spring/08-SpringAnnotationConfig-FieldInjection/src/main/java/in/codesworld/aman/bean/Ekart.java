package in.codesworld.aman.bean;

import org.springframework.stereotype.Component;

@Component
public class Ekart implements ICourier {

	static {
		System.out.println("Ekart.class file is loading.....");	
	}
	
	public Ekart() {
		System.out.println("Ekart object is created....");
	}
	
	@Override
	public String deliver(int oid) {
		return "Delivering "+oid+" orderid for order product using Ekart";
	}

}
