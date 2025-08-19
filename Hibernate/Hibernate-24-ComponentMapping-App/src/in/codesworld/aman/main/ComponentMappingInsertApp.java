package in.codesworld.aman.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.codesworld.aman.bean.Address;
import in.codesworld.aman.bean.StudentInfo;
import in.codesworld.aman.util.HibernateUtil;

public class ComponentMappingInsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Address address = new Address("#2/2", "FoodStreet", "VJYNGR", "BENGALURU", "IND", 560026L);
			StudentInfo student = new StudentInfo("nitin", 35.5f, address);
			session.save(student);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Record saved to database...");
			} else {
				transaction.rollback();
				System.out.println("Record not saved to database...");
			}
		}

	}
}
