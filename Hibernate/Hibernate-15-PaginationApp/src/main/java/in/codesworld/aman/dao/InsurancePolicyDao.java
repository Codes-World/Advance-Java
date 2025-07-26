package in.codesworld.aman.dao;

import java.util.List;

import in.codesworld.aman.entity.InsurancePolicy;

public interface InsurancePolicyDao {
	public long getTotalRecordsCount();
	public List<InsurancePolicy> getPageData(int pageSize, int startPos);
}
