package in.codesworld.aman.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.codesworld.aman.bean.LibraryMembership;
import in.codesworld.aman.bean.Student;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		try {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure().addAnnotatedClass(LibraryMembership.class)
						.addAnnotatedClass(Student.class).buildSessionFactory();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
