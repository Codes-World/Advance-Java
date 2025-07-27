package in.codesworld.aman.main;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.codesworld.aman.util.HibernateUtil;

public class NativeSQLScalarQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		

		try {
			
			//SaclarQuery-> NATIVE SQL QUERY WITH MAPPING TO ENTITY CLASS
			session = HibernateUtil.getSession();
			NativeQuery<Object[]> query1 = session.createSQLQuery("select policyId, policyName, company from insurancePolicy where tenure>=:max1 and tenure<=:max2");
			
			//setting the value to  namedparameter(max1 and max2)
			query1.setParameter("max1", 5);
			query1.setParameter("max2", 25);
			
			
			List<Object[]> list = query1.getResultList();
			list.forEach(object->{
				for(Object row : object) {
					System.out.print(row+" ");
				}
				System.out.println();
			});
			
			System.out.println("\n*************************************************************\n");
			
			NativeQuery<String> query2 = session.createSQLQuery("select company from insurancePolicy where tenure>=:max1 and tenure<=:max2");
			
			//setting the value to  namedparameter(max1 and max2)
			query2.setParameter("max1", 5);
			query2.setParameter("max2", 25);
			
			List<String> result = query2.getResultList();
			result.forEach(System.out::println);
			
			
			
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
