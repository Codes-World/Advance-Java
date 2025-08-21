package in.codesworld.aman.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.codesworld.aman.bean.CardPayment;
import in.codesworld.aman.bean.ChequePayment;
import in.codesworld.aman.bean.Payment;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
							.configure()
							.addAnnotatedClass(Payment.class)
							.addAnnotatedClass(CardPayment.class)
							.addAnnotatedClass(ChequePayment.class)
							.buildSessionFactory();
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
