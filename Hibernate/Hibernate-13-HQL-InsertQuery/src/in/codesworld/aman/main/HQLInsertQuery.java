package in.codesworld.aman.main;

import in.codesworld.aman.dao.InsurancePolicyDao;
import in.codesworld.aman.dao.InsurancePolicyDaoImpl;

public class HQLInsertQuery {

	public static void main(String[] args) {
		InsurancePolicyDao dao = new InsurancePolicyDaoImpl();
		String status = dao.transferPolicies(25);
		System.out.println(status);
	}
}
