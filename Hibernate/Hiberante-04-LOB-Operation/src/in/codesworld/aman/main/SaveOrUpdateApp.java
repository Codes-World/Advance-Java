package in.codesworld.aman.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.codesworld.aman.bean.Naukri;
import in.codesworld.aman.util.HibernateUtil;

public class SaveOrUpdateApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		Boolean flag = false;
		byte[] image = null;
		char[] resume = null;
		FileInputStream fis = null;
		BufferedReader br = null;

		try {
			
			//reading an image data
			fis = new FileInputStream("D:\\Documents\\Personal\\Picture1.jpg");
			int size = fis.available();
			image = new byte[size];
			fis.read(image);
			
			//reading a resume data
			File file = new File("D:\\Documents\\aman.txt");
			br = new BufferedReader(new FileReader(file));
			resume = new char[(int)file.length()];
			br.read(resume);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//logic for HIBERNATE working
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Naukri naukri = new Naukri();
			naukri.setAddress("bengaluru");
			naukri.setName("karthik");
			naukri.setImage(image);
			naukri.setResume(resume);
			session.saveOrUpdate(naukri);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
				} else {
					transaction.rollback();
					System.out.println("Record failed for updation...");
				}

				HibernateUtil.closeSessionFactory();
				if (session != null) {
					session.close();
				}
			}
		}
	}
}
