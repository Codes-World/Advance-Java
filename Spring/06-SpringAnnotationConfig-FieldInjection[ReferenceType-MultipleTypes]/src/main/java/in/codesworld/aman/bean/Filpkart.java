package in.codesworld.aman.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import in.codesworld.aman.config.ICourier;

@Component
public class Filpkart {	
	@Autowired
	@Qualifier("fedEx")
	private ICourier courier;

	@Override
	public String toString() {
		return "Filpkart [courier=" + courier + "]";
	}
}
