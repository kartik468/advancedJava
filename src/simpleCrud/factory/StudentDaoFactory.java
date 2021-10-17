package simpleCrud.factory;

import simpleCrud.dao.StudentDao;
import simpleCrud.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao studentDao;
	
	static {
		studentDao = new StudentDaoImpl();
	}
	
	public static StudentDao getStudentDao() {
		return studentDao;
	}
}
