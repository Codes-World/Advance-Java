package in.codesworld.aman.service;

import java.util.List;

import in.codesworld.aman.entity.InsurancePolicyDTO;

public interface InsurancePolicyManagementService {
	public long fetchPagesCount(int pageSize);
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo);
}
