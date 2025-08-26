package in.codesworld.aman.main;

import in.codesworld.aman.dao.ILibraryDao;
import in.codesworld.aman.dao.LibraryDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		ILibraryDao dao = new LibraryDaoImpl();
		dao.loadRecordUsingParent();
	}
}
