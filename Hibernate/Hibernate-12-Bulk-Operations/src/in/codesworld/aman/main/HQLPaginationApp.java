package in.codesworld.aman.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.codesworld.aman.bean.InsurancePolicy;
import in.codesworld.aman.util.HibernateUtil;

public class HQLPaginationApp {

	public static void main(String[] args) {

		Session session = null;
		Query<InsurancePolicy> query = null;
		List<InsurancePolicy> listOfRecords = null;

		try {
			session = HibernateUtil.getSession();
			query = session.createQuery("FROM in.codesworld.aman.bean.InsurancePolicy");
			
			//Pagination settings
			query.setFirstResult(2);
			query.setMaxResults(3);
			
			//run the query using HQL
			listOfRecords = query.getResultList();
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
