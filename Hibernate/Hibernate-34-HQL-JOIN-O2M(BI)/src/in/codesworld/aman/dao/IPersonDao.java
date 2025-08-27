package in.codesworld.aman.dao;

public interface IPersonDao {

	// performing select operation using parent
	public void loadRecordUsingJoinsParentToChild();
	public void loadRecordUsingJoinsChildToParent();

}
