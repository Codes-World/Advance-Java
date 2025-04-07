package in.codesworld.aman.beans;

public class Student {

	private String name;
	private Integer age;
	private String address;
	
	static {
		System.out.println("Student.class file is loading...");
	}
	
	public String getName() {
		System.out.println("Student.getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("Student.setName() :: " + name);
		this.name = name;
	}

	public Integer getAge() {
		System.out.println("Student.getAge()");
		return age;
	}

	public void setAge(Integer age) {
		System.out.println("Student.setAge() :: " + age);
		this.age = age;
	}

	public String getAddress() {
		System.out.println("Student.getAddress()");
		return address;
	}

	public void setAddress(String address) {
		System.out.println("Student.setAddress() :: " + address);
		this.address = address;
	}

	public Student() {
		System.out.println("Student Object is created...");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	

}
