package in.codesworld.aman.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.codesworld.aman.bean.InsurancePolicy;
import in.codesworld.aman.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		Query<InsurancePolicy> query = null;
		List<InsurancePolicy> listOfRecords = null;

		try {
			session = HibernateUtil.getSession();
			query = session.createQuery("FROM in.codesworld.aman.bean.InsurancePolicy");
			listOfRecords = query.getResultList();
			
			System.out.println("\nRetrieved using foreach and lambda expression....");
			listOfRecords.forEach(policy-> System.out.println(policy));
			
			System.out.println();
			System.out.println("Retrieved using foreach and method reference....");
			listOfRecords.forEach(System.out::println);
			
			System.out.println("**************************");
			
			System.out.println("Working with Named parameter.........");
			session = HibernateUtil.getSession();
			query = session.createQuery("FROM in.codesworld.aman.bean.InsurancePolicy WHERE company IN (:org1, :org2)");
			
			//set the named parameter value
			query.setParameter("org1", "HDFC");
			query.setParameter("org2", "SBI");
			
			//execute and retrieve the records
			listOfRecords = query.getResultList();
			
			//print the result
			listOfRecords.forEach(System.out::println);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}
}
