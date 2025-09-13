package in.codesworld.aman.service;

import in.codesworld.aman.beans.CustomerDTO;

public interface ICustomerService {
	public String calculateSimpleInterest(CustomerDTO dto)throws Exception;
}
