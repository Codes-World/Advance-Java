package in.codesworld.aman.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.codesworld.aman.config.ICourier;

@Component
public class Filpkart {	
	@Value("#{dtdc}")
	private ICourier courier;

	@Override
	public String toString() {
		return "Filpkart [courier=" + courier + "]";
	}
}
