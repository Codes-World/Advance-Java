package in.codesworld.aman.bean;

import org.springframework.stereotype.Component;

@Component
public class FedEx implements ICourier {

	static {
		System.out.println("FedEx.class file is loading.....");	
	}
	
	public FedEx() {
		System.out.println("FedEx object is created....");
	}
	
	@Override
	public String deliver(int oid) {
		return "Delivering "+oid+" orderid for order product using FedEx";
	}

}
