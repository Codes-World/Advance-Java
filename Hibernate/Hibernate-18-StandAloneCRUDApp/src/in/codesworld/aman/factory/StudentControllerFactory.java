package in.codesworld.aman.factory;

import in.codesworld.aman.controller.IStudentController;
import in.codesworld.aman.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static IStudentController controller = null;

	public static IStudentController getStudentControllerObj() {
		if (controller == null) {
			controller = new StudentControllerImpl();
		}
		return controller;
	}

}
