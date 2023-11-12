package in.ineuron.daofactory;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;




public class StudentDaoFactory {

	//Making the class private so that we can't create an object of this class.
	private StudentDaoFactory() {}
	
	private static IStudentDao studentDao = null;
	
	//SingleTon design Pattern::
	public static IStudentDao getStudentDao() {
		
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
	
}
