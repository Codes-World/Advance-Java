package in.codesworld.aman.bean;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Userdefined class
@Component(value="wmg")
public class WishMessageGenerator {
	
	static {
		System.out.println("WishMessageGenerate.class file is loading...");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerate object created using zero param....");
	}
	
	//HAS-A[Inbuilt type]
	@Autowired
	private LocalDateTime date;
	
	//Business Logic
	public String wishMessage(String user) {
		int hour = date.getHour();
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

	@Override
	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}
	
	

}
