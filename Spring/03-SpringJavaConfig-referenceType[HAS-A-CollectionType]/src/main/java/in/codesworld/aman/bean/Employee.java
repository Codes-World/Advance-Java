package in.codesworld.aman.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//primitive variable
	private int eid;
	private float salary;
	
	//collection variable
	private List<String> friends;
	private Set<String> phoneNumber;
	private Map<String, String> accountNumbers;
	
	static {
		System.out.println("Employee.class file is loading...");
	}

	
	//Constructor
	public Employee(int eid, float salary, List<String> friends, Set<String> phoneNumber,
			Map<String, String> accountNumbers) {
		this.eid = eid;
		this.salary = salary;
		this.friends = friends;
		this.phoneNumber = phoneNumber;
		this.accountNumbers = accountNumbers;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", salary=" + salary + ", friends=" + friends + ", phoneNumber=" + phoneNumber
				+ ", accountNumbers=" + accountNumbers + "]";
	}
	
	
	

}
