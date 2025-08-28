package in.codesworld.aman.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.codesworld.aman.bean.InsurancePolicy;
import in.codesworld.aman.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		Transaction transaction = session.beginTransaction();
		InsurancePolicy policy = new InsurancePolicy();
		policy.setCompany("SBI");
		policy.setPolicyName("SBIANAND");
		policy.setPolicyType("quarter");
		policy.setTenure(10);
		session.save(policy);
		transaction.commit();

	}

}
