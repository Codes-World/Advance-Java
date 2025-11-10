package in.codesworld.aman.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EKart implements ICourier {

	@Override
	public String deliverOrder(Integer oid) {
		
		return null;
	}

	@Override
	public String toString() {
		return "EKart [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
