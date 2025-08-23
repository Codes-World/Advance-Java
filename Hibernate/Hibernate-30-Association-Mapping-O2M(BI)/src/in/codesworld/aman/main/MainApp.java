package in.codesworld.aman.main;

import in.codesworld.aman.dao.IPersonDao;
import in.codesworld.aman.dao.PersonDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		IPersonDao dao = new PersonDaoImpl();
		dao.loadRecordUsingChild();
	}
}
