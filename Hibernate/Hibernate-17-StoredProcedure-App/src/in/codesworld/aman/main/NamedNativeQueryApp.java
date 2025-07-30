package in.codesworld.aman.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.codesworld.aman.bean.Product;
import in.codesworld.aman.util.HibernateUtil;

public class NamedNativeQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();
			NativeQuery<Product> query = session.getNamedNativeQuery("callStoredProcedure");
			query.setParameter("product1", "fossil");
			query.setParameter("product2", "tissot");

			List<Product> list = query.getResultList();
			list.forEach(System.out::println);
			
			
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
