package in.codesworld.aman.bean;

import java.io.Serializable;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component("bat")
public class CricketBat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("CricketBat.class file is loading...");
	}

	public CricketBat() {
		System.out.println("CricketBat Object created :: Zero param...");
	}
	
	public int scoreRuns() {
		System.out.println("CricketBat.scoreRuns()...");
		return new Random().nextInt(200);
	}
}
