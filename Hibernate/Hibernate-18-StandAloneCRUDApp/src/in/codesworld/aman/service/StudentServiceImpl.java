package in.codesworld.aman.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import in.codesworld.aman.bean.StudentBO;
import in.codesworld.aman.bean.StudentDTO;
import in.codesworld.aman.dao.IStudentRepo;
import in.codesworld.aman.factory.StudentRepoFactory;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String insertRecord(StudentDTO stdDto) {
		// Convert DTO to BO and send it to Repository layer
		System.out.println();
		StudentBO stdBo = new StudentBO();
		stdBo.setSname(stdDto.getSname());
		stdBo.setSaddress(stdDto.getSaddress());
		stdBo.setSage(stdDto.getSage());

		// Extra logic to save student information
		if (stdBo.getSage() >= 60) {
			stdBo.setStatus("SeniorCitizen");
		} else {
			stdBo.setStatus("Working People");
		}

		System.out.println("****SENDING BO TO REPOSITORY LAYER****\n");
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.insertRecord(stdBo);
	}

	@Override
	public StudentDTO readRecord(Integer sid) {

		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		StudentBO bo = null;
		StudentDTO dto = null;

		bo = repo.readRecord(sid);

		// convert bo to dto and send
		if (bo == null) {
			return dto;
		} else {
			try {
				dto = new StudentDTO();
				// copy data from bo to dto
				BeanUtils.copyProperties(dto, bo);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	@Override
	public String deleteRecord(Integer sid) {
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.deleteRecord(sid);
	}

	@Override
	public String updateRecord(StudentDTO stdDto) {
		
		StudentBO stdBo = new StudentBO();
		stdBo.setSid(stdDto.getSid());
		stdBo.setSname(stdDto.getSname());
		stdBo.setSaddress(stdDto.getSaddress());
		stdBo.setSage(stdDto.getSage());

		// Extra logic to save student information
		if (stdBo.getSage() >= 60) {
			stdBo.setStatus("SeniorCitizen");
		} else {
			stdBo.setStatus("Working People");
		}

		System.out.println("****SENDING BO TO REPOSITORY LAYER****\n");
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		
		return repo.updateRecord(stdBo);
	}
}
