package in.codesworld.aman.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.codesworld.aman.bean.Student;
import in.codesworld.aman.util.HibernateUtil;

public class SavePersistApp {
	public static void main(String[] args) {
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Integer Id = null;
		
		try{
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				Student student = new Student();
				student.setSname("rohit sharma");
				student.setSage(41);
				student.setSaddress("MI");
				
				Id = (Integer)session.save(student); //insert query : refering to DB information
				//session.persist(student);
				flag = true;
			}
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(flag) {
					System.in.read();
					transaction.commit();
					System.out.println("Object save into database with an id :: "+Id);
				}else {
					transaction.rollback();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			if(session != null) {
				session.close();
			}
		}
	}

}
