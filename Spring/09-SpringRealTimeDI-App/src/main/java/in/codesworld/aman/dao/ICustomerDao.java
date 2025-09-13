package in.codesworld.aman.dao;

import in.codesworld.aman.beans.CustomerBO;

public interface ICustomerDao {
	public int insert(CustomerBO bo) throws Exception;
}
