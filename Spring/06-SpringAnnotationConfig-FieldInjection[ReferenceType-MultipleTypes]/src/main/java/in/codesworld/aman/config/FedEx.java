package in.codesworld.aman.config;

import org.springframework.stereotype.Component;

@Component
public class FedEx implements ICourier {

	@Override
	public String deliverOrder(Integer oid) {
		
		return null;
	}

	@Override
	public String toString() {
		return "FedEx []";
	}

}
