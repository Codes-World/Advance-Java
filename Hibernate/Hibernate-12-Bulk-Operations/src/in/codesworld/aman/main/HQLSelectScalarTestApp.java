package in.codesworld.aman.main;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.codesworld.aman.bean.InsurancePolicy;
import in.codesworld.aman.util.HibernateUtil;

public class HQLSelectScalarTestApp {

	public static void main(String[] args) {

		Session session = null;
		Query query = null;
		List<Object[]> listOfRecords = null;

		try {
			session = HibernateUtil.getSession();
			query = session.createQuery("SELECT policyId, policyName FROM in.codesworld.aman.bean.InsurancePolicy WHERE policyId=:id");
			
			long id = 2L;
			//set named parameter for id
			query.setParameter("id", id);
			
			listOfRecords = query.getResultList();
			System.out.println(listOfRecords.size());
			if(!listOfRecords.isEmpty()) {
				//print the records
				Object[] object = listOfRecords.get(0);
				System.out.println(object[0]+" "+object[1]);
			}else {
				System.out.println("Record not available fro the given id :: "+id);
			}
			
			System.out.println("********************************************");
			query = session.createQuery("SELECT count(*) FROM in.codesworld.aman.bean.InsurancePolicy");
			List<?> list = query.getResultList();
			listOfRecords = query.getResultList();
			if(!listOfRecords.isEmpty()) {
				//print the records
				long count = (long)list.get(0);
				System.out.println("No of records is :: "+count);
			}
			
			System.out.println("**************************************");
			query = session.createQuery("FROM in.codesworld.aman.bean.InsurancePolicy WHERE policyId=:id");
			query.setParameter("id", 4L);
			Optional<InsurancePolicy> optional = query.uniqueResultOptional();
			if(optional.isPresent()) {
				InsurancePolicy policy = optional.get();
				System.out.println(policy);
			}else {
				System.out.println("Record not found.....");
			}
			
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
