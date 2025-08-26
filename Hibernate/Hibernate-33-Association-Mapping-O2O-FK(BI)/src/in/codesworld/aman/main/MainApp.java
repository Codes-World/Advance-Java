package in.codesworld.aman.main;

import in.codesworld.aman.dao.IPassportDao;
import in.codesworld.aman.dao.PassportDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		IPassportDao dao = new PassportDaoImpl();
		dao.loadRecordUsingParent();
	}
}
