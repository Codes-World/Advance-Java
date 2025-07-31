package in.codesworld.aman.service;

import in.codesworld.aman.bean.StudentDTO;

public interface IStudentService {
	public String insertRecord(StudentDTO stdDto);
	public StudentDTO readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentDTO stdDto);

}
