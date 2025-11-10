package in.codesworld.aman.config;
import org.springframework.stereotype.Component;

@Component(value="dtdc")
public class DTDC implements ICourier {

	@Override
	public String deliverOrder(Integer oid) {
		
		return null;
	}

	@Override
	public String toString() {
		return "DTDC [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
