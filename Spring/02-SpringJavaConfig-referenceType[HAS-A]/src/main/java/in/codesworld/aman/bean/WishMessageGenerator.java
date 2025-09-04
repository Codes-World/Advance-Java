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
	
	//Business Logic
	public String wishMessage(String user) {
		int hour = ldt.getHour();
		String msg = "";
		
		if(hour < 12) {
			msg += "Good Morning :: " + user;
		}else if(hour < 16) {
			msg += "Good Afternoon :: " + user;
		}else if(hour < 20) {
			msg += "Good Evening :: " + user;
		}else {
			msg += "Good night :: " + user;
		}
		
		return msg;
	}

}
