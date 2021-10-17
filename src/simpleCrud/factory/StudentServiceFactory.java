package simpleCrud.factory;

import simpleCrud.service.StudentService;
import simpleCrud.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService;
	
	static {
		studentService = new StudentServiceImpl();
	}
	
	public static StudentService getStudentService() {
		return studentService;
	}
}
