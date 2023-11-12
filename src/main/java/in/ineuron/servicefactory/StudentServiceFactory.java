package in.ineuron.servicefactory;
import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;



public class StudentServiceFactory {

	//Make a private constructor so that we can't create an instance of this class::
	private StudentServiceFactory() {}
	
	private static IStudentService studentService = null;
	
	//Single-ton design patters::
	public static IStudentService getStudentService() {
		
		if(studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
	
}
