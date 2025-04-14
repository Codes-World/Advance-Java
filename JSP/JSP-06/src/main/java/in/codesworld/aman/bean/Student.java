package in.codesworld.aman.bean;

public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	private String sname;
	private String saddress;
	private Integer sage;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}
	
	

}
