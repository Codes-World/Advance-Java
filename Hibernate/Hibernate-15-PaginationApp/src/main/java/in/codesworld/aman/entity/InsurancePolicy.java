package in.codesworld.aman.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "GET_POLICIES_COUNT", query = "SELECT count(*) FROM in.codesworld.aman.entity.InsurancePolicy")
@NamedQuery(name = "GET_ALL_POLICIES", query = "FROM in.codesworld.aman.entity.InsurancePolicy")
public class InsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;

	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;

	static {
		System.out.println("Hibernate-> Loading InsurancePolicy.class file...");
	}

	public InsurancePolicy() {
		System.out.println("Hibernate-> InsurancePolicy Object created using Zero param constructor...");
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}

}
