package in.codesworld.aman.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.codesworld.aman.bean.InsurancePolicy;
import in.codesworld.aman.util.HibernateUtil;

public class HQLDeleteQueryApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		long count = 0;
		try {

			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<InsurancePolicy> query = session.createQuery("DELETE FROM in.codesworld.aman.bean.InsurancePolicy where tenure>=:max");

			// setting the parameter
			query.setParameter("max", 30);

			// execute the query
			count = query.executeUpdate();
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records deleted are :: " + count);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}
}
