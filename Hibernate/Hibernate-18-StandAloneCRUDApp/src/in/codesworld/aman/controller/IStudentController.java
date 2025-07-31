package in.codesworld.aman.controller;

import in.codesworld.aman.bean.StudentVO;

public interface IStudentController {
	public String insertRecord(StudentVO student);
	public StudentVO readRecord(String sid);
	public String deleteRecord(String sid);
	public String updateRecord(StudentVO student);
}
