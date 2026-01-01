package in.codesworld.aman.bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public interface ICricketer {
	
	@Lookup
	public abstract CricketBat createCricketBat();
	
	public default void fielding() {
		System.out.println("Cricketer is doing fielding....");
	}
	
	public default void bowling() {
		System.out.println("Cricketer is doing bowling....");
	}
	
	public default void wicketkeeping() {
		System.out.println("Cricketer is doing wicketkeeping...");
	}
	
	public default void batting() {
		System.out.println("Cricketer is doing batting.....");
		
		//Performing Dependency Lookup to get the CricketBat object
		CricketBat bat = createCricketBat();
		int runs = bat.scoreRuns();
		System.out.println("Cricketer is doing batting and his current score is :: "+runs);
	}
}
