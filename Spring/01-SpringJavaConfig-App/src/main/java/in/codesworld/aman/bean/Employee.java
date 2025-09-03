package in.codesworld.aman.bean;

public class Employee {
	private Integer eid;
	private String ename;
	private Integer eage;
	private String eaadress;
	
	public Employee(){
		System.out.println("Employee Object created by IOC Container");	
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public String getEaadress() {
		return eaadress;
	}

	public void setEaadress(String eaadress) {
		this.eaadress = eaadress;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eaadress=" + eaadress + "]";
	}
	
	
}
