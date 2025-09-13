package in.codesworld.aman.bean;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Dtdc implements ICourier {

	static {
		System.out.println("Dtdc.class file is loading.....");	
	}
	
	public Dtdc() {
		System.out.println("Dtdc object is created....");
	}
	
	@Override
	public String deliver(int oid) {
		return "Delivering "+oid+" orderid for order product using DTDC";
	}

}
