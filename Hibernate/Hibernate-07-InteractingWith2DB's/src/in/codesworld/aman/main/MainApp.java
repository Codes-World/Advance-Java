package in.codesworld.aman.main;

import in.codesworld.aman.dao.TransferDao;
import in.codesworld.aman.dao.TransferDaoImpl;

public class MainApp {

	public static void main(String[] args) {
		
		TransferDao dao = null;
		dao = new TransferDaoImpl();
//		String status = dao.transferProductById(10);
		System.out.println("status :: "+dao.transferProductById(100));
	}

}
