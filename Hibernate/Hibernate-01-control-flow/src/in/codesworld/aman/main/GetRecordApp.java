package in.codesworld.aman.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.codesworld.aman.bean.Student;
import in.codesworld.aman.util.HibernateUtil;

public class GetRecordApp {
	public static void main(String[] args) {
		Session session = null;
		Scanner scanner = null;
		Student std1 = null;
		Student std2 = null;
		Student std3 = null;
		Student std4 = null;
		Integer sid = null;

		try {
			session = HibernateUtil.getSession();
			scanner = new Scanner(System.in);

			if (session != null && scanner != null) {
				System.out.print("Enter the sid value :: ");
				sid = scanner.nextInt();

				// performing read operation on database
				std1 = session.get(Student.class, sid); // Select Query :: DB to L1 cache
				System.out.println(std1 + " its hashCode value is :: " + std1.hashCode());
				
				// performing read operation on database
				std3 = session.get(Student.class,3);// Select Query :: DB to L1 cache
				System.out.println(std3 + " its hashCode value is :: " + std3.hashCode());
				
				
				System.in.read();
				
				//removing std3 from L1 cache
				session.evict(std3);
				
				// performing read operation on database
				std2 = session.get(Student.class, 3);// Select Query
				System.out.println(std2 + " its hashCode value is :: " + std2.hashCode());


				// performing read operation on database
				std4 = session.get(Student.class, sid);// Select Query
				System.out.println(std4 + " its hashCode value is :: " + std4.hashCode());

			}
			
//			if(std1 != null) {
//				System.in.read();
//				System.out.println("STUDENT DETAILS");
//				System.out.println("SNAME IS    :: "+std1.getSname());
//				System.out.println("SID IS      :: "+std1.getSid());
//				System.out.println("SAGE IS     :: "+std1.getSage());
//				System.out.println("SADDRESS IS :: "+std1.getSaddress());
//			} else {
//				System.in.read();
//				System.out.println("Record not available for the given id :: "+sid);
//			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

}
