package in.codesworld.aman.bean;

import java.time.LocalDateTime;

//Userdefined class
public class WishMessageGenerator {
	
	static {
		System.out.println("WishMessageGenerate.class file is loading...");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerate object created using zero param....");
	}
	
	//HAS-A[Inbuilt type]
	private LocalDateTime ldt;
	
	public LocalDateTime getLdt() {
		return ldt;
	}
	
	//Setter Injection
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

}
