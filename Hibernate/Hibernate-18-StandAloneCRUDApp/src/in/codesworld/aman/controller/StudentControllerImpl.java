package in.codesworld.aman.controller;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import in.codesworld.aman.bean.StudentDTO;
import in.codesworld.aman.bean.StudentVO;
import in.codesworld.aman.factory.StudentServiceFactory;
import in.codesworld.aman.service.IStudentService;



public class StudentControllerImpl implements IStudentController {

	@Override
	public String insertRecord(StudentVO stdVo) {

		System.out.println();

		// Convert the VO into DTO and send it to Service Layer
		StudentDTO studentDto = new StudentDTO();

		studentDto.setSage(Integer.parseInt(stdVo.getSage()));
		studentDto.setSname(stdVo.getSname());
		studentDto.setSaddress(stdVo.getSaddress());

		System.out.println("*****SENDING DTO to SEERVICE LAYER******\n");
		IStudentService service = StudentServiceFactory.getStudentService();
		return service.insertRecord(studentDto);
	}

	@Override
	public StudentVO readRecord(String sid) {

		IStudentService service = StudentServiceFactory.getStudentService();

		StudentDTO dto = null;
		StudentVO vo = null;

		dto = service.readRecord(Integer.parseInt(sid));

		if (dto == null) {
			return vo;
		} else {
			// convert dto to vo and send
			vo = new StudentVO();
			try {
				BeanUtils.copyProperties(vo, dto);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vo;
		}
	}

	@Override
	public String deleteRecord(String sid) {
		IStudentService service = StudentServiceFactory.getStudentService();
		String status = service.deleteRecord(Integer.parseInt(sid));
		return status;
	}

	@Override
	public String updateRecord(StudentVO stdVo) {
		IStudentService service = StudentServiceFactory.getStudentService();

		// Convert the VO into DTO and send it to Service Layer
		StudentDTO studentDto = new StudentDTO();

		studentDto.setSid(Integer.parseInt(stdVo.getSid()));
		studentDto.setSage(Integer.parseInt(stdVo.getSage()));
		studentDto.setSname(stdVo.getSname());
		studentDto.setSaddress(stdVo.getSaddress());

		return service.updateRecord(studentDto);
	}
}
