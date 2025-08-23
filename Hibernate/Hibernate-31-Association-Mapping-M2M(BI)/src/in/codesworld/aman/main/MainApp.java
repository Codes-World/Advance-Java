package in.codesworld.aman.main;

import in.codesworld.aman.dao.IHospitalDao;
import in.codesworld.aman.dao.HospitalDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		IHospitalDao dao = new HospitalDaoImpl();
		dao.saveRecordUsingParent();
	}
}
