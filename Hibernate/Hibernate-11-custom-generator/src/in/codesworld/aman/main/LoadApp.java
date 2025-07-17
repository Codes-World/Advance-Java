package in.codesworld.aman.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.codesworld.aman.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			
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
